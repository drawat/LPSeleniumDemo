package LPMAOSeleniumPOC.Utilities.Browser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class JIRAIntegration {

	public static final String JIRA_BASE_URL = "https://oxfordinc.atlassian.net/rest/api/2/issue/";
	public static final String AuthToken ="ATATT3xFfGF0nhVL-qHPiJ6bwviEdn-h3wG4GqgKJCa0nZrp30zGI5A876YQ1Hgcr57-rraXPiJAhGlcSMc3ePlG3JM0-tS86GY1FnnNomEC9QH71NJ54cIaOf84vXV9c4W5kVY3Mh-z1FyCwGcvafI0a1I6GEvDoKerOJfsLARuE4Ua5rwbc6U=1D4F4E84";
	String credentials = "drawat@deloitte.com" + ":" + AuthToken;
    String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
	public JIRAIntegration() {
		
	}
	
	public void updateJIRAStatus(String issueID, String trnsID) {
		String url = JIRA_BASE_URL + issueID + "/transitions";
		String jsonBody = "{\"transition\": {\"id\": \""+ trnsID + "\"}}";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);
		 httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
		try {
			StringEntity entity = new StringEntity(jsonBody);
			httpPost.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException i) {
			i.printStackTrace();
		}
         
	}
	
	public void addJIRAComments (String issueID, String strComment) {
		String url = JIRA_BASE_URL + issueID + "/comment";
		//System.out.println(url);
		String jsonBody = "{\"body\": \"" + strComment + "\"}";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);
		 httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
		try {
			StringEntity entity = new StringEntity(jsonBody);
			httpPost.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			//System.out.println("response Stats code  "+ response.getStatusLine().getStatusCode());
		//	String responseBody = EntityUtils.toString(response.getEntity());
           // System.out.println("Response Body: " + responseBody);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException i) {
			i.printStackTrace();
		}
         
	}
	
	public void uploadAttachmentToJIRA(String issueID, String fileName) {
		String url = JIRA_BASE_URL + issueID + "/attachments";
		System.out.println("Url:   "+ url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);
		
		httpPost.setHeader("X-Atlassian-Token", "no-check");

	        File fileToUpload = new File("C:\\Users\\DRAWAT\\eclipse-workspace\\LPSeleniumDemo\\" + fileName);
	       
	        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	       
	       builder.addPart("file", new FileBody(fileToUpload));
	       builder.addTextBody("type", "file");
	     
	        HttpEntity multipartEntity = builder.build();
	        httpPost.setEntity(multipartEntity);
	        try {
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        System.out.println("response Stats code  "+ response.getStatusLine().getStatusCode());
			
			  String responseBody = EntityUtils.toString(response.getEntity()); //
			  System.out.println("Response Body: " + responseBody);
			 	        }catch (IOException i) {
				i.printStackTrace();
			}
	}
}
	