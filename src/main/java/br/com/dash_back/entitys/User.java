package br.com.dash_back.entitys;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Builder
public class User {

    @GeneratedValue
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

}
