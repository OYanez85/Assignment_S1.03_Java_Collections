package Level_1.Exercise_2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main_2 {
    public static void main(String[] args) {
        System.out.println("Initializing the first list with elements 1, 2, 3, 4, 5...");
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);
        System.out.println("First List: " + firstList);

        System.out.println("Creating second list to store reversed elements of the first list...");
        List<Integer> secondList = new ArrayList<>();

        System.out.println("Reversing the first list...");
        ListIterator<Integer> listIterator = firstList.listIterator(firstList.size());

        while (listIterator.hasPrevious()) {
            int element = listIterator.previous();
            System.out.println("Adding element to the second list: " + element);
            secondList.add(element);
        }

        System.out.println("Second List (Reversed): " + secondList);
    }
}
