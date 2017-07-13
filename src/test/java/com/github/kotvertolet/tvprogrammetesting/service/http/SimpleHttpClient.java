package com.github.kotvertolet.tvprogrammetesting.service.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SimpleHttpClient {

    public CloseableHttpResponse get(String uri) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response;
        try {
            response = httpclient.execute(httpGet);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
