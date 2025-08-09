package com.wipro.relationdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.relationdemo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
