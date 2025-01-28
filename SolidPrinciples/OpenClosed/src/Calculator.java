public class Calculator {
    public int calculate(int x, int y, Operations operations) {
        return operations.performOperation(x, y);
    }
}
