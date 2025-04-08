package customer;

public class Customer {
    private final String id;
    private final String name;
    private String email;
    private String phoneNo;
    private final DriversLicense driversLicense;

    public Customer(String id, String name, String email, String phoneNo, DriversLicense driversLicense) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.driversLicense = driversLicense;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }
}
