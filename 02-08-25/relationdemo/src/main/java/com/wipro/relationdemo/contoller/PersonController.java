package com.wipro.relationdemo.contoller;
import com.wipro.relationdemo.entity.Person;
import com.wipro.relationdemo.repo.PersonRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        // Cascade will save Posts as well
        return personRepo.save(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }
}
