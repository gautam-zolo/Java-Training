
import java.util.*;
import java.lang.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your Todo Application!");
        char op = '0';
        Scanner sc = new Scanner(System.in);

        Todo app = new Todo();

        while (op != 'g') {

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
                    app.addTask();
                    break;
                case 'b':
                    app.display();
                    break;
                case 'c':
                    app.deleteTask();
                    break;
                case 'd':
                    System.out.print("Enter id of task to be marked completed: ");
                    app.markCompleted();
                    break;
                case 'e':
                    app.groupByDate();
                    break;

                case 'f':
                    app.search();
                    break;
                case 'g':

            }
        }

    }
}