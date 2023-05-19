package com.rk.springdatabase.springdata;

import com.rk.springdatabase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
