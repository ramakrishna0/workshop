package com.rk.springdatabase;

import com.rk.springdatabase.entity.Person;
import com.rk.springdatabase.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner {
	@Autowired
	private PersonJdbcDao personJdbcDao;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personJdbcDao.findAll());
		logger.info("FindById 10002 - {}", personJdbcDao.findById(10002));
		logger.info("findByLocation(USA) - {}", personJdbcDao.findByLocation("USA"));
		logger.info("deleteById(10002) -{}", personJdbcDao.deleteById(10002));

		Person person = new Person(10010, "RK", "India", Timestamp.from(Instant.now()));

		logger.info("insert(person) - {} - {}", personJdbcDao.insert(person), person);
		person.setName("Krishna");
		logger.info("update(person) - {} - {}", personJdbcDao.update(person), person);
		logger.info("All users -> {}", personJdbcDao.findAll());
	}
}
