package mediator;

import course.Course;
import users.Administrator;
import users.Instructor;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseMediatorImpl implements CourseMediator {
    private final List<Course> courseList = new ArrayList<>();
    private Administrator administrator;

    @Override
    public boolean createCourse(Instructor instructor, String courseName) {
        if (findCourseUsingCourseName(courseName) == null) {
            Course course = new Course(courseName, instructor);
            instructor.addCourse(course);
            courseList.add(course);
            return true;
        }
        return false;
    }

    @Override
    public int getTotalNumberOfEnrolledStudentsInCourse(Course course) {
        return course.getTotalNumberOfEnrolledStudents();
    }

    @Override
    public boolean enrollToCourse(Student student, String courseName) {
        Course course = findCourseUsingCourseName(courseName);
        if(course == null) return false;
        if(course.findIfStudentHasAlreadyEnrolled(student)) return false;
        if(administrator != null && !administrator.canEnroll(course)) return false;

        student.addCourse(course);
        course.addStudent(student);
        return true;
    }

    @Override
    public void unEnrollToCourse(Student student, String courseName) {
        Course course = findCourseUsingCourseName(courseName);
        if(course == null) return;

        student.removeCourse(course);
        course.removeStudent(student);
    }

    @Override
    public void setAdministrator(Administrator administrator) {
        if(this.administrator != null) return;
        this.administrator = administrator;
    }

    @Override
    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    public List<Student> getEnrolledStudentForCourse(Course course) {
        return course.getEnrolledStudents();
    }

    @Override
    public Instructor getInstructorForCourse(Course course) {
        return course.getCourseInstructor();
    }

    private Course findCourseUsingCourseName(String courseName) {
        for(Course course : courseList) {
            if(course.getCourseName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }
}
