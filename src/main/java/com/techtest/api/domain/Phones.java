package com.techtest.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
