package data;

import java.time.LocalDate;

public class User {
    private final String name;
    private final LocalDate dateOfBirth;
    private final String phoneNo;
    private final String email;

    public User(String name, LocalDate dateOfBirth, String phoneNo, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}
