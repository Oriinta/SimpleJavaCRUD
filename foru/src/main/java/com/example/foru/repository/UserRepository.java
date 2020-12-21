package com.example.foru.repository;

import com.example.foru.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);
}
