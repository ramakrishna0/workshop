package com.rk.springaop;

import com.rk.springaop.business.Business1;
import com.rk.springaop.business.Business2;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor 		//(onConstructor = @__(@Autowired)) --> using in spring version < 4.3
public class SpringAopApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// all variables are autowired automatically using @AllArgsConstructor or @RequiredArgsConstructor
	//Even though it is not listed, this annotation also has the onConstructor parameter.
	//Autowired variables should be unambiguous
//	@Autowired
	private final Business1 business1;
//	@Autowired
	private final Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}
}