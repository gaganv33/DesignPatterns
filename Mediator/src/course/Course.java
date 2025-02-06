package course;

import users.Instructor;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final Instructor instructor;
    private final String name;
    private final List<Student> enrolledStudents;

    public Course(String name, Instructor instructor) {
        this.instructor = instructor;
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return this.name;
    }

    public Instructor getCourseInstructor() {
        return this.instructor;
    }

    public int getTotalNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    public boolean findIfStudentHasAlreadyEnrolled(Student student) {
        return enrolledStudents.contains(student);
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public List<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }
}
