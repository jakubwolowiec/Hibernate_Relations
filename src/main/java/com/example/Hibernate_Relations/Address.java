package com.example.Hibernate_Relations;

import javax.persistence.*;

@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street;
    private String city;
    private String houseNo;



    public Address(String street, String city, String houseNo) {
        this.street = street;
        this.city = city;
        this.houseNo = houseNo;
    }

    public Address() {

    }
}
