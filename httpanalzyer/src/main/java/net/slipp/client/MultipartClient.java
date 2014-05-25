package net.slipp.client;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class MultipartClient {
	public static void main(String[] args) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://localhost:5000/");

		FileBody bin = new FileBody(new File("pom.xml"));
		StringBody comment = new StringBody("Filename: pom.xml");

		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("bin", bin);
		reqEntity.addPart("comment", comment);
		httppost.setEntity(reqEntity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
	}
}
