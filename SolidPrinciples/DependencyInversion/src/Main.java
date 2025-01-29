public class Main {
    public static void main(String[] args) {
        CalculatorOperations additionOperations = new AdditionOperation();
        CalculatorOperations subtractionOperations = new SubtractionOperation();

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(6, 6, additionOperations));
        System.out.println(calculator.calculate(7, 9, subtractionOperations));
    }
}