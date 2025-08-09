package com.wipro.relationdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.relationdemo.entity.Genre;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
