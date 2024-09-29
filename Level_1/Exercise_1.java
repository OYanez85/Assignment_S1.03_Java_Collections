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

        
        months.add(7, new Month("August"));

        
        System.out.println("ArrayList (Ordered):");
        for (Month month : months) {
            System.out.println(month.getName());
        }

        
        HashSet<Month> uniqueMonths = new HashSet<>(months);

        
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
