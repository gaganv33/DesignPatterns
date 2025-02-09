import java.util.Stack;

public class CareTaker {
    private final Stack<Memento> mementoList;

    public CareTaker() {
        this.mementoList = new Stack<>();
    }

    public void addState(Memento memento) {
        mementoList.push(memento);
    }

    public Memento popState() {
        if(mementoList.isEmpty()) {
            return null;
        }
        return mementoList.pop();
    }
}
