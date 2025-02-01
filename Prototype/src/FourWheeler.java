public class FourWheeler extends Vehicle {
    private Boolean isDiesel;

    public FourWheeler(String engine, String model, Long price, Boolean isAutomatic, Boolean isDiesel) {
        super(engine, model, price, isAutomatic);
        this.isDiesel = isDiesel;
    }

    public Boolean getDiesel() {
        return isDiesel;
    }

    public void setDiesel(Boolean diesel) {
        isDiesel = diesel;
    }

    @Override
    public FourWheeler clone() throws CloneNotSupportedException {
        return (FourWheeler) super.clone();
    }
}
