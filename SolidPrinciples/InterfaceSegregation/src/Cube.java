public class Cube implements Shape3D {
    private int side;

    Cube() {

    }

    Cube(int side) {
        this.side = side;
    }

    @Override
    public void area() {
        long area = (long) 6 * side * side;
        System.out.println("Area of cube: " + area);
    }

    @Override
    public void volume() {
        long volume = (long) side * side * side;
        System.out.println("Volume of cube: " + volume);
    }
}
