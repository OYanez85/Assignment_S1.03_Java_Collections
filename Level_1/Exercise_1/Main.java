package Level_1.Exercise_1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Month objects without "August"
        ArrayList<Month> months = new ArrayList<>();
        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        // Verify the ArrayList before inserting "August"
        System.out.println("ArrayList of months (before inserting August):");
        for (Month month : months) {
            System.out.println(month);
        }

        // Insert "August" in the correct position (index 7 for zero-based index)
        months.add(7, new Month("August"));

        // Verify that the ArrayList is in the correct order after inserting "August"
        System.out.println("\nArrayList of months (after inserting August):");
        for (Month month : months) {
            System.out.println(month);
        }

        // Convert ArrayList to LinkedHashSet to ensure no duplicates and maintain order
        LinkedHashSet<Month> monthSet = new LinkedHashSet<>(months);

        // Traverse the LinkedHashSet using an iterator
        System.out.println("\nLinkedHashSet of months (no duplicates, maintains insertion order):");
        Iterator<Month> iterator = monthSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
