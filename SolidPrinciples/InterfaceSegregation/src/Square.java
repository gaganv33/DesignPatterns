public class Square implements Shape2D {
    private int side;

    Square() {

    }

    Square(int side) {
        this.side = side;
    }

    @Override
    public void area() {
        long area = (long) side * side;
        System.out.println("Area of square: " + area);
    }
}
