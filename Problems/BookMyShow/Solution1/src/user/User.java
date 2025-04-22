package user;

import java.time.LocalDate;

public class User {
    private final String name;
    private final String email;
    private final String phoneNo;
    private final LocalDate dateOfBirth;
    public User(String name, String email, String phoneNo, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
