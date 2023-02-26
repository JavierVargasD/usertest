package com.techtest.api.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@IdClass(Phones.class)
public class Phones {
    @Id
    @GeneratedValue
    private long id;

    private String number;


    private String citycode;


    private String contrycode;

    @Override
    public String toString() {
        return "Phones{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }
}
