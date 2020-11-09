package com.uwjx.components.commons.network;

import okhttp3.*;

import java.io.IOException;

public class HttpRequest {

    OkHttpClient client = new OkHttpClient();

    public String get(String url) throws Exception {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("ok http GET request error");
    }

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");


    public String post(String url, String json) throws Exception {
        try {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("ok http POST request error");
    }

    public String post(String url, String basicUsername, String basicPassword, String json) throws Exception {
        try {
            String credentials = Credentials.basic(basicUsername , basicPassword);
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .header("Authorization", credentials)
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("ok http POST request error");
    }

    public String post(String url, String basicUsername, String basicPassword) throws Exception {
        try {
            String credentials = Credentials.basic(basicUsername , basicPassword);
            RequestBody body = RequestBody.create(JSON , "{}");
            Request request = new Request.Builder()
                    .header("Authorization", credentials)
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("ok http POST request error");
    }
}
