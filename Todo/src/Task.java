import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    int id;
    String title;
    String text;
    String dt;
    boolean fin = false;

    public String getDate() {
        return dt;
    }

    public void display() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        try {
            date = dateFormat.parse(dt);
        } catch (ParseException e) {
            System.out.println("oops");
        }

        String formattedDate = dateFormat.format(date);
        System.out.println("______________________________");
        System.out.println("Task ID: " + id);
        System.out.println("Task Title: " + title);
        System.out.println("Task Description: " + text);
        System.out.println("Task Date: " + formattedDate);
        if (fin)
            System.out.println("Task Status: Completed ");
        else
            System.out.println("Task Status: Pending ");
    }
}