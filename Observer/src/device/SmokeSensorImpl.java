package device;

public class SmokeSensorImpl extends SmokeSensor {
    public SmokeSensorImpl(String name) {
        super(name);
    }

    @Override
    public void onNotifyOnSmoke() {
        System.out.println(this.name + " : Smoke detected and activating the water sprinklers and alarm");
    }
}
