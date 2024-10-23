package com.bitspondon.pos.application.repository;

import com.bitspondon.pos.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
