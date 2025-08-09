package com.wipro.relationdemo.repo;
import com.wipro.relationdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {}

