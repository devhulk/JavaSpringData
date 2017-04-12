package com.example.Models;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by mad1 on 4/12/17.
 */

@Repository
public class Pokemon {

    @Id
    int id;

    @Column
    String name;

    @Column
    int height;

    @Column
    int weight;

    public Pokemon() {
    }

    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }


}
