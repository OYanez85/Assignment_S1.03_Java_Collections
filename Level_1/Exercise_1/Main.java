package Level_1.Exercise_1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("ArrayList of months (before inserting August):");
        for (Month month : months) {
            System.out.println(month);
        }

        months.add(7, new Month("August"));

        System.out.println("\nArrayList of months (after inserting August):");
        for (Month month : months) {
            System.out.println(month);
        }

        LinkedHashSet<Month> monthSet = new LinkedHashSet<>(months);

        System.out.println("\nLinkedHashSet of months (no duplicates, maintains insertion order):");
        Iterator<Month> iterator = monthSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
