package com.topica.vn.repository;

import com.topica.vn.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    Optional<Category> findById(Long id);
    Page<Category> findByTypesId(Long types_id, Pageable pageable);
}
