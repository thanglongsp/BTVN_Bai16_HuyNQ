package com.topica.vn.service.impl;

import com.topica.vn.model.Category;
import com.topica.vn.model.Item;
import com.topica.vn.repository.CategoryRepository;
import com.topica.vn.repository.ItemRepository;
import com.topica.vn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findByCategory(String category, int pageIndex, int pageSize) {
        Category category1 = categoryRepository.findByName(category);
        Page<Item> items = itemRepository.findByCategoryId(category1.getId(), new PageRequest(pageIndex, pageSize));
        return items.getContent();
    }
}
