package tvProgrammeTesting.service.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SimpleHttpClient {

    private CloseableHttpResponse response;

    public CloseableHttpResponse get(String uri) {
        if (response != null) {
            closeResponseStream();
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response;
        try {
            response = httpclient.execute(httpGet);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            closeResponseStream();
        }
        return null;
    }

    private void closeResponseStream() {
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
