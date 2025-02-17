package com.example.pro.repository;

import com.example.pro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNom(String nom);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.prix = :prix WHERE p.id = :id")
    int updatePrixById(Long id, double prix);
}

