import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private static volatile ElevatorManager instance;

    private final List<Elevator> elevators;

    private ElevatorManager() {
        this.elevators = new ArrayList<>();
    }

    public static ElevatorManager getInstance() {
        if(instance == null) {
            synchronized (ElevatorManager.class) {
                if(instance == null) {
                    instance = new ElevatorManager();
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

    public void addRequest(Request request) {
        Elevator elevator = findOptimalElevator(request);
        if(request.source() < request.destination()) {
            elevator.addUpRequest(request);
        } else {
            elevator.addDownRequest(request);
        }
    }

    private Elevator findOptimalElevator(Request request) {
        int waiting_time = Integer.MAX_VALUE;
        Elevator elevator = null;

        for(var elevator1 : elevators) {
            if(elevator1.getIsIdleElevator()) {
                System.out.println("Found an idle elevator " + elevator1.getElevatorId() + " for " + request.source() + " " + request.destination());
                return elevator1;
            }
            int value = elevator1.getWaitingTimeForGivenRequest(request);
            if(value < waiting_time) {
                waiting_time = value;
                elevator = elevator1;
            }
        }
        assert elevator != null;
        System.out.println("Did not find an idle elevator " + elevator.getElevatorId() + " for " + request.source() + " " + request.destination());
        return elevator;
    }
}
