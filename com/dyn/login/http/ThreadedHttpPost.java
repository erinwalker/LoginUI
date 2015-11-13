package com.dyn.login.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;

import com.dyn.login.reference.Reference;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class ThreadedHttpPost extends Thread {

	private final static String SECRET_KEY = "e2607b00a2055b99736f63464ba565ea830dbeb714c2d02a6f62e390d943574c820ae61671540ca9967c66140cc5188c3e5cfc145ba7ede870f648b8d95c2acc";
	private final static String ORG_KEY = "38f5bab69e94db89fac757eed98d900585a05baaa1aa20b71251ca323a53ef92";

	public ThreadedHttpPost() {
		setName("Achievement Mod update checker thread");
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		try {
			HttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost("http://chicago.col-engine-staging.com/partner_organizations/api.json");

			// decode the base64 encoded string
			byte[] decodedKey = Base64.getDecoder().decode(
					"e2607b00a2055b99736f63464ba565ea830dbeb714c2d02a6f62e390d943574c820ae61671540ca9967c66140cc5188c3e5cfc145ba7ede870f648b8d95c2acc");
			// rebuild key using SecretKeySpec
			SecretKey theSecretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

			HmacSHA256Signer signer = new HmacSHA256Signer(null, null, theSecretKey.getEncoded());

			// Configure JSON token with signer and SystemClock
			JsonToken token = new JsonToken(signer);
			token.setExpiration(Instant.now().plusSeconds(300)); // 5 Minutes
			token.setParam("version", "v1");
			token.setSubject("badges");

			System.out.println(token.getTokenAsString());
			// httppost.setEntity(token.serializeAndSign(), "UTF-8");

			StringEntity params = new StringEntity(token.serializeAndSign());
			httppost.setHeader("Accept", "application/json");
			httppost.setHeader("Authorization", "JWT token=" + ORG_KEY);
			httppost.setEntity(params);

			// Execute and get the response.
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					String reply = "";
					int data = instream.read();
					while (data != -1) {
						char theChar = (char) data;
						reply = reply + theChar;
						data = instream.read();
					}
					System.out.println(reply);
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
