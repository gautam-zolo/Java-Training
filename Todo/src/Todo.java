import java.util.*;
import java.lang.*;
import java.text.*;

public class Todo {

    List<Task> taskList = new ArrayList<>();
    int id = 0;
    Scanner sc = new Scanner(System.in);
    boolean found = false;

    public void addTask() {
        Task task = new Task();
        id++;
        System.out.println("Your task ID is: " + id);
        task.id = id;
        System.out.print("Enter Task Title: ");
        task.title = sc.nextLine();

        System.out.print("Enter Task Description: ");
        task.text = sc.nextLine();

        boolean dateIsValid = false;

        while (!dateIsValid) {
            System.out.print("Enter a date (format: yyyy-MM-dd): ");
            String userInput = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                // Parse the user input into a Date object
                Date date = dateFormat.parse(userInput);
                // You can perform various operations with the 'date' object if needed
                task.dt = userInput;
                dateIsValid = true;

            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        System.out.println("Successfully added: ");
        taskList.add(task);
        task.display();
    }

    public void display() {
        if (taskList.isEmpty()) {
            System.out.println("No Tasks to show ");
            return;
        }
        System.out.println("Here is the task list: ");

        for (Task t : taskList)
            t.display();

    }

    public void deleteTask() {
        System.out.print("Enter id of task to be deleted: ");
        int del = sc.nextInt();
        found = false;
        for (Task t : taskList) {
            if (t.id == del) {
                taskList.remove(t);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Task deletion success");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void markCompleted() {
        int com = sc.nextInt();
        found = false;
        for (Task t : taskList) {
            if (t.id == com) {
                t.fin = true;
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Task Completed");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void groupByDate() {
        if (taskList.isEmpty()) {
            System.out.println("No Tasks to show ");
            break;
        }
        System.out.println("All your tasks are now grouped by date: ");
        taskList.sort(Comparator.comparing(Task::getDate));
        for (Task t : taskList)
            t.display();
    }

    public void search() {

        if (taskList.isEmpty()) {
            System.out.println("No Tasks to show ");
            return;
        }
        System.out.print(" Enter the task's keyword you are searching for: ");
        String word = sc.nextLine();
        found = false;
        Task T = new Task();
        for (Task t : taskList) {
            if (t.text.startsWith(word)) {
                T = t;
                found = true;
                T.display();
            }
        }
        if (!found) {
            System.out.println("Task not found!");
        }
    }
}