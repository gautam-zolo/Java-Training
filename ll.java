import java.util.*;
public class JavaExample{
  public static void main(String args[]){
    LinkedList<String> linkList=new LinkedList<>();
    linkList.add("Apple"); //["Apple"]
    linkList.add("Orange"); //["Apple", "Orange"]

    //inserting element at first position
    linkList.add(0, "Banana"); ////["Banana", "Apple", "Orange"]

    System.out.println("LinkedList elements: ");
    //iterating LinkedList using iterator
    Iterator<String> it=linkList.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }
  }
}
