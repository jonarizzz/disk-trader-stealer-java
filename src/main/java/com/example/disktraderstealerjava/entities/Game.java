package com.example.disktraderstealerjava.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "titles")
public class Game {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "psn_url")
    private String psnURL;
    @Column(name = "price_usd")
    private String priceUsd;
    @Column(name = "publisher")
    private String publisher;
}
