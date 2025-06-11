package com.course.api.book.service;

import com.course.api.book.service.exceptions.ApiRequestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumption {

    private final HttpClient client;

    public ApiConsumption(HttpClient client) {
        this.client = client;
    }

    public String getData(String address) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if(statusCode >= 200 && statusCode < 300) {
                return response.body();
            } else {
                throw new ApiRequestException("Error in API response. Code: " + statusCode);
            }
        } catch (IOException e) {
            throw new ApiRequestException("IO error during request to: " + address, e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiRequestException("Request interrupted for: " + address, e);
        }
    }
}
