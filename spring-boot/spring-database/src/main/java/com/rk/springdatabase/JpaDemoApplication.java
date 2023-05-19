/*
package com.rk.springdatabase;

import com.rk.springdatabase.entity.Person;
import com.rk.springdatabase.jdbc.PersonJdbcDao;
import com.rk.springdatabase.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	@Autowired
	private PersonJpaRepository jpaRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person("Jon Doe 1", "USA", Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person = new Person ("Jon Doe 2", "USA", Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person = new Person ("Jon Doe 3", "USA", Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person = new Person ("Jon Doe 4", "USA", Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person = new Person ("Jon Doe 5", "USA", Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person = new Person ("Ranga", "Hyderabad",Date.from(Instant.now()));
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		logger.info("FindById 6 - {}", jpaRepository.findById(6));

		person.setLocation("Hyd");
		logger.info("{}", jpaRepository.insertOrUpdate(person));
		person.setId(7);
		person.setLocation("HYD");
		logger.info("{}", jpaRepository.insertOrUpdate(person));

		logger.info("findById 4 - {}", jpaRepository.findById(4));

		logger.info("removing person with id 7");
		jpaRepository.deleteById(person.getId());
		logger.info("findById 7 - {}", jpaRepository.findById(7));

		logger.info("List of all persons - findAll() - {}", jpaRepository.findAll());

	}
}
*/
