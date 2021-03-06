package com.example.repositories;

import com.example.entities.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressSqlRepository extends JpaRepository<Address, Long> {
    
}
