package com.tradk.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private String status;
    private int price;
}
