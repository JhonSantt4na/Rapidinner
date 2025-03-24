package com.santt4na.rapidinner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.rapidinner.model.business.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
