import java.util.*;

public class Elevator extends Thread {
    private final long elevatorId;
    private int currentFloor;
    private ElevatorDirection elevatorDirection;
    private ElevatorStatus elevatorStatus;
    private final PriorityQueue<Request> upRequests;
    private final PriorityQueue<Request> downRequests;
    private final Queue<Request> pendingJobs;

    public Elevator(long elevatorId) {
        this.elevatorId = elevatorId;
        currentFloor = 0;
        elevatorDirection = ElevatorDirection.IDLE;
        elevatorStatus = ElevatorStatus.IDLE;
        upRequests = new PriorityQueue<>((a, b) -> a.destination() - b.destination());
        downRequests = new PriorityQueue<>((a, b) -> b.destination() - a.destination());
        pendingJobs = new LinkedList<>();
    }

    public long getElevatorId() {
        return this.elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorDirection getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public PriorityQueue<Request> getUpRequests() {
        return upRequests;
    }

    public PriorityQueue<Request> getDownRequests() {
        return downRequests;
    }

    public Queue<Request> getPendingJobs() {
        return pendingJobs;
    }

    public synchronized boolean getIsIdleElevator() {
        return this.elevatorStatus.equals(ElevatorStatus.IDLE);
    }

    @Override
    public void run() {
        moveElevator();
    }

    public void addUpRequest(Request request) {
        synchronized (this) {
            System.out.print("Adding up request : " + elevatorId + " ");
            if(this.currentFloor <= request.source()) {
                System.out.println("added to up request queue");
                upRequests.offer(request);
                notifyAll();
            } else {
                System.out.println("added to pending queue");
                pendingJobs.add(request);
                notifyAll();
            }
        }
    }

    public void addDownRequest(Request request) {
        synchronized (this) {
            System.out.print("Adding down request : " + elevatorId + " ");
            if(this.currentFloor >= request.source()) {
                System.out.println("added to down request queue");
                downRequests.offer(request);
                notifyAll();
            } else {
                System.out.println("added to pending queue");
                pendingJobs.add(request);
                notifyAll();
            }
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void moveElevator() {
        while (true) {
            if (this.elevatorStatus.equals(ElevatorStatus.IDLE)) {
                if(checkUpRequestsAndUpdate()) continue;
                else if(checkDownRequestsAndUpdate()) continue;
                else if(checkForPendingRequest()) continue;
                idleStateElevator();
            } else {
                if (this.elevatorDirection.equals(ElevatorDirection.UP)) {
                    movingUpStateElevator();
                } else if (this.elevatorDirection.equals(ElevatorDirection.DOWN)) {
                    movingDownStateElevator();
                }
            }
        }
    }

    private boolean checkUpRequestsAndUpdate() {
        synchronized (this) {
            if(!upRequests.isEmpty()) {
                setElevatorDirection(ElevatorDirection.UP);
                setElevatorStatus(ElevatorStatus.MOVING);
                return true;
            }
            return false;
        }
    }

    private boolean checkDownRequestsAndUpdate() {
        synchronized (this) {
            if(!downRequests.isEmpty()) {
                setElevatorDirection(ElevatorDirection.DOWN);
                setElevatorStatus(ElevatorStatus.MOVING);
                return true;
            }
            return false;
        }
    }

    private boolean checkForPendingRequest() {
        synchronized (this) {
            if (this.pendingJobs.isEmpty()) return false;
            Request request = pendingJobs.poll();
            addPendingRequest(request);
            return true;
        }
    }

    private void addPendingRequest(Request request) {
        synchronized (this) {
            System.out.println("Moving elevator: " + this.elevatorId + " from " + this.currentFloor + " to " + request.source());
            if (request.source() < request.destination()) {
                this.currentFloor = request.source();
                addUpRequest(request);
            } else {
                this.currentFloor = request.source();
                addDownRequest(request);
            }
        }
    }

    private void idleStateElevator() {
        synchronized (this) {
            System.out.println("Elevator ID : " + this.elevatorId + " is in IDLE state (wait).");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }

    private void movingUpStateElevator() {
        while(!upRequests.isEmpty()) {
            synchronized (this) {
                Request request = upRequests.poll();
                if(request == null) continue;
                System.out.println("Moving elevator: " + this.elevatorId + " to source: " + request.source());
                this.currentFloor = request.source();
                try {
                    sleep(3000); // simulating the elevator moving
                } catch (InterruptedException e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                while(currentFloor < request.destination()) {
                    this.currentFloor += 1;
                    System.out.println("Elevator: " + elevatorId + " is at floor: " + this.currentFloor);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
                System.out.println("Elevator: " + elevatorId + " reached floor (destination): " + this.currentFloor);
            }
        }
        setElevatorToIdle();
    }

    private void movingDownStateElevator() {
        while(!downRequests.isEmpty()) {
            synchronized (this) {
                Request request = downRequests.poll();
                if(request == null) continue;
                System.out.println("Moving elevator: " + this.elevatorId + " to source: " + request.source());
                try {
                    sleep(3000); // simulating the elevator moving
                } catch (InterruptedException e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                while(currentFloor > request.destination()) {
                    this.currentFloor -= 1;
                    System.out.println("Elevator: " + elevatorId + " is at floor: " + this.currentFloor);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
                System.out.println("Elevator: " + elevatorId + " reached floor (destination): " + this.currentFloor);
            }
        }
        setElevatorToIdle();
    }

    private void setElevatorToIdle() {
        synchronized (this) {
            setElevatorStatus(ElevatorStatus.IDLE);
            setElevatorDirection(ElevatorDirection.IDLE);
        }
    }

    public int getWaitingTimeForGivenRequest(Request request) {
        synchronized (this) {
            if(this.elevatorStatus.equals(ElevatorStatus.IDLE)) {
                return Math.abs(request.source() - this.currentFloor);
            } else {
                if(this.elevatorDirection.equals(ElevatorDirection.UP)) {
                    if(this.currentFloor < request.source()) {
                        return (request.source() - this.currentFloor);
                    } else {
                        if(upRequests.isEmpty()) return 0;
                        else {
                            List<Request> upListRequest = new ArrayList<>(upRequests);
                            int lastFloor = upListRequest.get(upListRequest.size() - 1).destination();
                            return (lastFloor - request.source());
                        }
                    }
                } else {
                    if(this.currentFloor > request.source()) {
                        return (this.currentFloor - request.source());
                    } else {
                        if(downRequests.isEmpty()) return 0;
                         else {
                            List<Request> downListRequest = new ArrayList<>(downRequests);
                            int lastFloor = downListRequest.get(downListRequest.size() - 1).destination();
                            return (this.currentFloor - lastFloor);
                        }
                    }
                }
            }
        }
    }
}
