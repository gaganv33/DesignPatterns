import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private static volatile ElevatorManager instance;
    private final List<Elevator> elevators;
    private ElevatorStrategy elevatorStrategy;

    private ElevatorManager(ElevatorStrategy elevatorStrategy) {
        this.elevators = new ArrayList<>();
        this.elevatorStrategy = elevatorStrategy;
    }

    public static ElevatorManager getInstance() {
        if(instance == null) {
            synchronized (ElevatorManager.class) {
                if(instance == null) {
                    instance = new ElevatorManager(new NearestElevatorStrategy());
                }
            }
        }
        return instance;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void addElevator(Elevator elevator) {
        elevator.start();
        elevators.add(elevator);
    }

    public boolean removeElevator(int elevatorId) {
        Elevator elevator1 = null;
        for(var elevator : elevators) {
            if(elevator.getElevatorId() == elevatorId && elevator.getElevatorStatus().equals(ElevatorStatus.IDLE)) {
                elevator.interrupt();
                elevator1 = elevator;
            }
        }
        if(elevator1 != null) {
            elevators.remove(elevator1);
        }
        return false;
    }

    public void setElevatorStrategy(ElevatorStrategy elevatorStrategy) {
        this.elevatorStrategy = elevatorStrategy;
    }

    public void addRequest(Request request) {
        Elevator elevator = findOptimalElevator(request);
        if(request.source() < request.destination()) {
            elevator.addUpRequest(request);
        } else {
            elevator.addDownRequest(request);
        }
    }

    private Elevator findOptimalElevator(Request request) {
        return elevatorStrategy.findOptimalElevator(elevators, request);
    }
}
