package com.topica.vn.service;

import com.topica.vn.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByType(String type, int pageIndex, int pageSize);
    void updateCategory(Long id, String name);
}
