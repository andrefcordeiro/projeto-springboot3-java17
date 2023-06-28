package com.cursojava.projetospring.repositories;

import com.cursojava.projetospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
