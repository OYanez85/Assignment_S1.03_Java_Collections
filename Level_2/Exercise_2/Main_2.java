package Level_2.Exercise_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        // Your program logic here
        System.out.println("Running Main_2 program...");
        
        // Example logic to test
        List<Restaurant_1> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant_1("Restaurant A", 5));
        restaurants.add(new Restaurant_1("Restaurant B", 4));
        
        // Sort and display the restaurants
        Collections.sort(restaurants);
        for (Restaurant_1 restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
