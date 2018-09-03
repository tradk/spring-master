package com.darkness.service.many2one;

import com.darkness.entity.many2one.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
