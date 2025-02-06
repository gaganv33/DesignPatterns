package mediator;

import course.Course;
import users.Administrator;
import users.Instructor;
import users.Student;

import java.util.List;

public interface CourseMediator {
    boolean createCourse(Instructor instructor, String courseName);
    int getTotalNumberOfEnrolledStudentsInCourse(Course course);
    boolean  enrollToCourse(Student student, String courseName);
    void unEnrollToCourse(Student student, String courseName);
    void setAdministrator(Administrator administrator);
    List<Course> getCourseList();
    List<Student> getEnrolledStudentForCourse(Course course);
    Instructor getInstructorForCourse(Course course);
}
