package users;

import mediator.CourseMediator;

public abstract class User {
    protected final String name;
    protected final CourseMediator courseMediator;

    public User(String name, CourseMediator courseMediator) {
        this.name = name;
        this.courseMediator = courseMediator;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
