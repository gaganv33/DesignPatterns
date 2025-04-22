package search;

public class Request {
    private final String name;
    private final String city;
    private final String state;
    private final String country;

    public Request(String name, String city, String state, String country) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public boolean isCityBlank() {
        return this.city.isBlank();
    }

    public boolean isStateBlank() {
        return this.state.isBlank();
    }

    public boolean isCountryBlank() {
        return this.country.isBlank();
    }

    public  boolean isCityNotBlank() {
        return !this.city.isBlank();
    }

    public boolean isStateNotBlank() {
        return !this.state.isBlank();
    }

    public boolean isCountryNotBlank() {
        return !this.country.isBlank();
    }
}
