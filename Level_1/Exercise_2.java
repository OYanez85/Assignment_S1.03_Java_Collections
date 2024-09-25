import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create and fill a List<Integer>
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        System.out.println("First List: " + firstList);

        // Step 2: Create a second List<Integer>
        List<Integer> secondList = new ArrayList<>();

        // Step 3: Use ListIterator to read elements from the first list and insert them in reverse order into the second list
        ListIterator<Integer> listIterator = firstList.listIterator(firstList.size());

        while (listIterator.hasPrevious()) {
            secondList.add(listIterator.previous());
        }

        // Step 4: Print the second list to verify reverse order
        System.out.println("Second List (Reversed): " + secondList);
    }
}
