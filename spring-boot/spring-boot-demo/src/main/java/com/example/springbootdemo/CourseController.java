package com.example.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @RequestMapping("/retrieveallcourses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "RK"),
                new Course(2, "Learn DevOps", "RK"),
                new Course(3, "Learn Azure", "RK"),
                new Course(4, "Programming 101", "RK")
        );
    }
}
