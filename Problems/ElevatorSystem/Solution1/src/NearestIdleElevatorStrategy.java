import java.util.List;
import java.util.Random;

public class NearestIdleElevatorStrategy implements ElevatorStrategy {
    @Override
    public Elevator findOptimalElevator(List<Elevator> elevators, Request request) {
        int minDistance = Integer.MAX_VALUE;
        Elevator result = null;

        for(var elevator : elevators) {
            if(elevator.getIsIdleElevator()) {
                int value = elevator.getWaitingTimeForGivenRequest(request);
                if(value < minDistance) {
                    minDistance = value;
                    result = elevator;
                }
            }
        }

        if(result == null) {
            result = elevators.get(new Random().nextInt(elevators.size()));
        }
        return result;
    }
}
