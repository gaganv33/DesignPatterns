import java.util.ArrayList;
import java.util.List;

public class TaskList implements Task {
    private String title;
    private final List<Task> taskList;

    public TaskList(String title) {
        this.title = title;
        taskList = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        for(Task task : taskList) {
            task.display();
        }
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }
}
