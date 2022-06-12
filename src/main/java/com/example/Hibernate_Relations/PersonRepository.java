package com.example.Hibernate_Relations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Override
    Optional<Person> findById(Long aLong);
}
