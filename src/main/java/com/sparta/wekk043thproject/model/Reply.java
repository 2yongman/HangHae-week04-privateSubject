package com.sparta.wekk043thproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Column(nullable = false)
    private String contents;

}
