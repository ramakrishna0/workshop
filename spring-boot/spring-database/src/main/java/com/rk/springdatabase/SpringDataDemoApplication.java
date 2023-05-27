package com.rk.springdatabase;

import com.rk.springdatabase.entity.Person;
import com.rk.springdatabase.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.Instant;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	@Autowired
	private PersonSpringDataRepository springDataRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("---------------------------------------------------------------------------------------------");

		Person person = new Person("Jon Doe 1", "USA", Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		person = new Person ("Jon Doe 2", "USA", Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		person = new Person ("Jon Doe 3", "USA", Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		person = new Person ("Jon Doe 4", "USA", Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		person = new Person ("Jon Doe 5", "USA", Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		person = new Person ("Ranga", "Hyderabad",Date.from(Instant.now()));
		logger.info("{}", springDataRepository.save(person));
		logger.info("FindById 6 - {}", springDataRepository.findById(6));

		person.setLocation("Hyd");
		logger.info("{}", springDataRepository.save(person));
		person.setId(7);
		person.setLocation("HYD");
		logger.info("{}", springDataRepository.save(person));

		logger.info("findById 4 - {}", springDataRepository.findById(4));

		logger.info("removing person with id 7");
		springDataRepository.deleteById(person.getId());
		logger.info("findById 7 - {}", springDataRepository.findById(7));

		logger.info("List of all persons - findAll() - {}", springDataRepository.findAll());

		logger.info("---------------------------------------------------------------------------------------------");


	}
}
