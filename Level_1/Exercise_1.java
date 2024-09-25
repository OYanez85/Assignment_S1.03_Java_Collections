import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Month {
    private String name;

    public Month(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Month month = (Month) obj;
        return name.equals(month.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class Main {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList and add 11 months (except August)
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

        // Step 2: Insert August in the correct position (after July)
        months.add(7, new Month("August"));

        // Step 3: Display the ArrayList to demonstrate the correct order
        System.out.println("ArrayList (Ordered):");
        for (Month month : months) {
            System.out.println(month.getName());
        }

        // Step 4: Convert the ArrayList to a HashSet to ensure no duplicates
        HashSet<Month> uniqueMonths = new HashSet<>(months);

        // Step 5: Iterate through the HashSet using a for loop and an iterator
        System.out.println("\nHashSet (No Duplicates):");
        for (Month month : uniqueMonths) {
            System.out.println(month.getName());
        }

        System.out.println("\nUsing Iterator:");
        Iterator<Month> iterator = uniqueMonths.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
