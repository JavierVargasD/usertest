package com.techtest.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Getter @Setter
public class TUser {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Phones> phones;
}
