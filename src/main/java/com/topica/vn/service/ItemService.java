package com.topica.vn.service;

import com.topica.vn.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);
}
