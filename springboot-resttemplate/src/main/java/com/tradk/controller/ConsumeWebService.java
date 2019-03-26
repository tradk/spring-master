package com.tradk.controller;

import com.tradk.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public ResponseEntity<List<Product>> getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Product>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://localhost:3000/products",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Product>>() {});
        return response;
    }
}
