package users;

import course.Course;
import course.CourseData;
import mediator.CourseMediator;

import java.util.List;

public class Administrator extends User {
    public Administrator(String name, CourseMediator courseMediator) {
        super(name, courseMediator);
    }

    public boolean canEnroll(Course course) {
        return (courseMediator.getTotalNumberOfEnrolledStudentsInCourse(course) < CourseData.MAX_CAPACITY);
    }

    public void manageCourse() {
        System.out.println("Manage courses");
        List<Course> courseList = courseMediator.getCourseList();
        for(Course course : courseList) {
            System.out.println(course.getCourseName());
            List<Student> enrolledStudent = courseMediator.getEnrolledStudentForCourse(course);
            for(Student student : enrolledStudent) {
                System.out.println(student);
            }
            System.out.println(courseMediator.getInstructorForCourse(course));
        }
    }
}
