package net.slipp.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetClient {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:5000/get?name=1234");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			System.out.println(response.getStatusLine().toString());
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		    	System.out.println("Body : " + EntityUtils.toString(entity));
		    }
		} finally {
		    response.close();
		}
	}
}
