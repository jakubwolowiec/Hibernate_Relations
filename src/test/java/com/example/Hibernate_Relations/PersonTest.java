package com.example.Hibernate_Relations;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {



    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;


    @BeforeEach
    public void clean(){
        personRepository.deleteAll();
        addressRepository.deleteAll();
    }
    @Test
    public void shouldFindOne(){
    //given
         Address address = new Address("Naury","Rybnik","66");
         Person personA = new Person("James", "Nowacki",address);


    //when
        personRepository.save(personA);

    //then
        Assertions.assertThat(personRepository.findAll().size()).isEqualTo(1);
        Assertions.assertThat(addressRepository.findAll().size()).isEqualTo(1);
    }
    @Test
    public void shouldReturnAddress(){
    //given
        Address addressB = new Address("Legendy","Knurów","64");
        Person personB = new Person("Janek", "Nowak",addressB);

    //when

        Person save = personRepository.save(personB);
        save.getAddress().setCity("Goturtle BigPoland");

    //then

        Assertions.assertThat(addressRepository.findAddressByCity("Goturtle BigPoland")).isPresent();

    }
}