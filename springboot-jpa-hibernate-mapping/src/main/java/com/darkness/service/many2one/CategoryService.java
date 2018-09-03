package com.darkness.service.many2one;

import com.darkness.entity.many2one.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);
}
