package http.jdk;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaHttp {
    public static void main(String[] args) throws Exception {
        get("");

    }

    public static void get(String uri) throws Exception {
        String s = "{\"page\":1,\"per_page\":500,\"total\":1,\"total_pages\":1,\"data\":[{\"barcode\":\"74002314\",\"item\":\"Nightgown\",\"category\":\"Underwear\",\"price\":3705,\"discount\":20,\"available\":1}]}";
        /*
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        */
        JSONObject j = new JSONObject(s);
        JSONArray ja = j.getJSONArray("data");
        System.out.println(ja.length());
    }
}
