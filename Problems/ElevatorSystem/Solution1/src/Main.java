import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ElevatorManager elevatorManager = ElevatorManager.getInstance();
        elevatorManager.addElevator(new Elevator(1));
        elevatorManager.addElevator(new Elevator(2));
        Random random = new Random();

        for(int i = 0; i < 3; i++) {
            int source = random.nextInt(11);
            int destination = random.nextInt(11);
            if(source != destination) {
                System.out.println("Request: " + source + " " + destination);
                elevatorManager.addRequest(new Request(source, destination));
            }
        }
    }
}