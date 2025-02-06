package users;

import course.Course;
import mediator.CourseMediator;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private final List<Course> enrolledCourse;

    public Student(String name, CourseMediator courseMediator) {
        super(name, courseMediator);
        this.enrolledCourse = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.enrolledCourse.add(course);
    }

    public void removeCourse(Course course) {
        this.enrolledCourse.remove(course);
    }

    public boolean enrollToCourse(String courseName) {
        return courseMediator.enrollToCourse(this, courseName);
    }

    public void unEnrollToCourse(String courseName) {
        courseMediator.unEnrollToCourse(this, courseName);
    }
}
