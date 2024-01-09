

import java.util.*;
import java.lang.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your Todo Application!");
        char op = '0';
        boolean found;
        int id = 0;
        Scanner sc = new Scanner(System.in);
        List<Task> taskList = new ArrayList<>();


        while (op!='g') {

            System.out.println("______________________________");
            System.out.println("Choose one of the following option: ");
            System.out.println("(a) Create a task");
            System.out.println("(b) Display all tasks");
            System.out.println("(c) Delete a task");
            System.out.println("(d) Mark a task as completed");
            System.out.println("(e) Group Tasks by Date");
            System.out.println("(f) Search task by title");
            System.out.println("(g) Exit!");
            System.out.println("______________________________");

            op = sc.next().charAt(0);

            switch (op) {
                case 'a':
                    System.out.println("You choose to create a new task");
                    Task task = new Task();
                    id++;
                    System.out.println("Your task ID is: " + id);
                    task.id =id;

                    sc.nextLine();
                    System.out.print("Enter Task Title: ");
                    task.title = sc.nextLine();

                    System.out.print("Enter Task Description: ");
                    task.text = sc.nextLine();

                    boolean dateIsValid = false;

                    while(!dateIsValid) {
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
                    break;
                case 'b':
                    if(taskList.isEmpty()){
                        System.out.println("No Tasks to show ");
                        break;
                    }
                    System.out.println("Here is the task list: ");

                    for(Task t:taskList)
                            t.display();
                    break;
                case 'c':
                    System.out.print("Enter id of task to be deleted: ");
                    int del = sc.nextInt();
                    found = false;
                    for(Task t:taskList){
                        if(t.id == del){
                            taskList.remove(t);
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Task deletion success");
                    }else{
                        System.out.println("Task not found!");
                    }
                    break;
                case 'd':
                    System.out.print("Enter id of task to be marked completed: ");
                    int com = sc.nextInt();
                    found = false;
                    for(Task t:taskList){
                        if(t.id == com){
                            t.fin = true;
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Task Completed");
                    }else{
                        System.out.println("Task not found!");
                    }
                    break;
                case 'e':
                    if(taskList.isEmpty()){
                        System.out.println("No Tasks to show ");
                        break;
                    }
                    System.out.println("All your tasks are now grouped by date: ");
                    taskList.sort( Comparator.comparing(Task::getDate));
                    for(Task t:taskList)
                        t.display();
                    break;

                case 'f':
                    if(taskList.isEmpty()){
                        System.out.println("No Tasks to show ");
                        break;
                    }
                    System.out.print( " Enter the task's keyword you are searching for: ");
                    sc.nextLine();
                    String word = sc.nextLine();
                    found = false;
                    Task T = new Task();
                    for(Task t:taskList){
                        if(t.text.startsWith(word)){
                            T = t;
                            found = true;
                            T.display();
                        }
                    }
                    if(!found){
                        System.out.println("Task not found!");
                    }
                    break;

                case 'g':

            }
        }

    }
}