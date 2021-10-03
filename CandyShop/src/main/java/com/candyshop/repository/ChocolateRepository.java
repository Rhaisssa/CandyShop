package com.candyshop.repository;

import com.candyshop.model.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChocolateRepository  extends JpaRepository<Chocolate, Long> {
}
