package com.cursojava.projetospring.repositories;

import com.cursojava.projetospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
