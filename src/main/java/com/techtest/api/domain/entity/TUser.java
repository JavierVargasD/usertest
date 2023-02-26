package com.techtest.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.List;


@Entity
@Getter @Setter
public class TUser {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;
    private String name;
    private String email;
    private String password;
    private Date created;
    private Date modified;

    private Date lastLogin;
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phones> phones;

    @Override
    public String toString() {
        return "TUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }
}
