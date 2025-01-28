public class Main {
    public static void main(String[] args) {
        Operations additionOperations = new AdditionOperation();
        Operations subtractionOperations = new SubtractionOperation();
        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(10, 6, additionOperations));
        System.out.println(calculator.calculate(10, 6, subtractionOperations));
    }
}