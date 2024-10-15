package Level_2.Exercise_1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurantSet = new HashSet<>();

        // Adding restaurants
        restaurantSet.add(new Restaurant("Pizza Palace", 5));
        restaurantSet.add(new Restaurant("Burger Shack", 4));
        restaurantSet.add(new Restaurant("Pizza Palace", 3));  // Same name, different rating
        restaurantSet.add(new Restaurant("Sushi Spot", 5));
        restaurantSet.add(new Restaurant("Pizza Palace", 5));  // Duplicate, should not be added

        // Corrected for loop
        for (Restaurant restaurant : restaurantSet) {
            System.out.println(restaurant);  // Printing the restaurant object
        }
    }
}
