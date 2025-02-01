public abstract class Vehicle implements Cloneable {
    private String engine;
    private String model;
    private Long price;
    private Boolean isAutomatic;

    public Vehicle(String engine, String model, Long price, Boolean isAutomatic) {
        this.engine = engine;
        this.model = model;
        this.price = price;
        this.isAutomatic = isAutomatic;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(Boolean automatic) {
        isAutomatic = automatic;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "engine='" + engine + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", isAutomatic=" + isAutomatic +
                '}';
    }

    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }
}
