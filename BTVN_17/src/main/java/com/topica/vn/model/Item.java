package com.topica.vn.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}
