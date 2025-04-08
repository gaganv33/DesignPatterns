package customer;

import java.time.LocalDate;

public class DriversLicense {
    private final String name;
    private String phoneNo;
    private String address;
    private final int driversLicenseNo;
    private final LocalDate dateOfBirth;

    public DriversLicense(String name, String phoneNo, String address, int driversLicenseNo, LocalDate dateOfBirth) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.driversLicenseNo = driversLicenseNo;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDriversLicenseNo() {
        return driversLicenseNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
