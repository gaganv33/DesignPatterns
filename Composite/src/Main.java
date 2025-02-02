public class Main {
    public static void main(String[] args) {
        TaskList taskList1 = new TaskList("task list - 1");
        TaskList taskList2 = new TaskList("task list - 2");

        taskList2.addTask(new SimpleTask("task 2.1"));
        taskList2.addTask(new SimpleTask("task 2.2"));
        taskList2.addTask(new SimpleTask("task 2.3"));

        taskList1.addTask(new SimpleTask("task 1.1"));
        taskList1.addTask(new SimpleTask("task 1.2"));
        taskList1.addTask(taskList2);

        taskList1.display();
    }
}
