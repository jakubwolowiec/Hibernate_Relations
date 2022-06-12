package com.example.Hibernate_Relations;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;
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

}