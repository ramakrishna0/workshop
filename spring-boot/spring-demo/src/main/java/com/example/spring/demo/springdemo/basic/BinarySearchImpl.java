package com.example.spring.demo.springdemo.basic;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Setter
public class BinarySearchImpl {

//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm;
    public int binarySearch(int[] numbers, int numberToSearchFor) {
        sortAlgorithm.sort(numbers);
        return numberToSearchFor;
    }

    /*@PostConstruct
    public void postConstruct() {
        LOGGER.info("post construct");
    }

    @PreDestroy
    public void perDestory() {
        LOGGER.info("preDestory method");
    }*/

}
