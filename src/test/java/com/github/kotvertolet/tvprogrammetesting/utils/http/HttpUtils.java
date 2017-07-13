package com.github.kotvertolet.tvprogrammetesting.utils.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    public static String getResponseBodyString(CloseableHttpResponse response) {
        return getResponseBodyString(response, "UTF-8");
    }

    public static String getResponseBodyString(CloseableHttpResponse response, String responseEncoding) {
        String body = null;
        try {
            body = EntityUtils.toString(response.getEntity(), responseEncoding);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }


}
