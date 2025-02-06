import mediator.CourseMediator;
import mediator.CourseMediatorImpl;
import users.Administrator;
import users.Instructor;
import users.Student;

public class Main {
    public static void main(String[] args) {
        CourseMediator courseMediator = new CourseMediatorImpl();

        Administrator administrator = new Administrator("administrator", courseMediator);
        Student student1 = new Student("student 1", courseMediator);
        Student student2 = new Student("student 2", courseMediator);
        Student student3 = new Student("student 3", courseMediator);
        Instructor instructor1 = new Instructor("instructor 1", courseMediator);
        Instructor instructor2 = new Instructor("instructor 2", courseMediator);

        courseMediator.setAdministrator(administrator);
        if(instructor1.createCourse("DSA")) {
            System.out.println("DSA course created");
        } else {
            System.out.println("Failed to create DSA course");
        }
        if(instructor2.createCourse("Java")) {
            System.out.println("Java course created");
        } else {
            System.out.println("Failed to create Java course");
        }

        student1.enrollToCourse("DSA");
        student2.enrollToCourse("DSA");
        student3.enrollToCourse("Java");
        administrator.manageCourse();
        student1.unEnrollToCourse("DSA");
        student2.enrollToCourse("Java");
        student3.enrollToCourse("DSA");
        student1.unEnrollToCourse("Java");
        administrator.manageCourse();
    }
}