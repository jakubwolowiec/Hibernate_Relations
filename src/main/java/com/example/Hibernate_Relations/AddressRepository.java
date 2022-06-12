package com.example.Hibernate_Relations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    Optional<Address> findById(Long aLong);
    Optional<Address> findAddressByCity(String city);
}
