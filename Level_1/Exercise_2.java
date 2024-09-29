import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        System.out.println("First List: " + firstList);

        
        List<Integer> secondList = new ArrayList<>();

        
        ListIterator<Integer> listIterator = firstList.listIterator(firstList.size());

        while (listIterator.hasPrevious()) {
            secondList.add(listIterator.previous());
        }

        
        System.out.println("Second List (Reversed): " + secondList);
    }
}
