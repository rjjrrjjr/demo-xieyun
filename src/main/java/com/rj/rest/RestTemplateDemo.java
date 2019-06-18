package com.rj.rest;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ruanj on 2019/6/15.
 */
public class RestTemplateDemo {


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/swagger-ui.html";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 160; i++) {
            executorService.submit(() -> restTemplate.getForEntity(url, Object.class, new MultiValueMap()));
        }
    }
}
