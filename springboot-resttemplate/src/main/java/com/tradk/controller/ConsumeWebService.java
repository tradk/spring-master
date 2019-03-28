package com.tradk.controller;

import com.tradk.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Get list data
     */
    @RequestMapping(value = "/template/products")
    public String getProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:3000/products",
                HttpMethod.GET, entity,
                String.class).getBody();
    }

    /**
     * Add new product
     */
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange(
                "http://localhost:3000/products",
                HttpMethod.POST, entity,
                String.class).getBody();
    }

    /**
     * Update product
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange(
                String.format("http://localhost:3000/products/%d", id),
                HttpMethod.PUT, entity,
                String.class).getBody();
    }

    /**
     * Delete product
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                String.format("http://localhost:3000/products/%d", id),
                HttpMethod.DELETE, entity,
                String.class).getBody();
    }

}
