import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy {
    @Override
    public Elevator findOptimalElevator(List<Elevator> elevators, Request request) {
        int waiting_time = Integer.MAX_VALUE;
        Elevator result = null;

        for(var elevator : elevators) {
            int value = elevator.getWaitingTimeForGivenRequest(request);
            if(value < waiting_time) {
                waiting_time = value;
                result = elevator;
            }
        }

        return result;
    }
}
