import java.util.List;

public interface ElevatorStrategy {
    Elevator findOptimalElevator(List<Elevator> elevators, Request request);
}
