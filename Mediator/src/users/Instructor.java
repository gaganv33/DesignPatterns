package users;

import course.Course;
import mediator.CourseMediator;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private final List<Course> courseList;
    public Instructor(String name, CourseMediator courseMediator) {
        super(name, courseMediator);
        this.courseList = new ArrayList<>();
    }

    public boolean createCourse(String courseName) {
        if(courseMediator.createCourse(this, courseName)) {
            System.out.println("Course created");
            return true;
        }
        System.out.println("Course creation failed");
        return false;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }
}
