package com.marcosoft.marcosoftcustomerexample.client;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class CustomerClient {

    private final HttpClient httpClient = HttpClient.newBuilder().build();

    public HttpRequest buildRequest(String method, String endPointSuffix, String requestBody){
        String apiEndPoint = "http://localhost:8081/";
        URI apiUri = URI.create(apiEndPoint + endPointSuffix);
        return HttpRequest.newBuilder()
                .uri(apiUri)
                .method(method, HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .build();
    }

    public HttpResponse<String> sendRequest(HttpRequest httpRequest){
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return httpResponse;
    }

}
