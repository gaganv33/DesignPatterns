package location;

public class Location {
    private final double latitude;
    private final double longitude;
    private final String city;
    private final String state;
    private final String country;

    public Location(double latitude, double longitude, String city, String state, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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

    public boolean isMatchingCity(String city) {
        return this.city.equalsIgnoreCase(city);
    }

    public boolean isMatchingState(String state) {
        return this.state.equalsIgnoreCase(state);
    }

    public boolean isMatchingCountry(String country) {
        return this.country.equalsIgnoreCase(country);
    }
}
