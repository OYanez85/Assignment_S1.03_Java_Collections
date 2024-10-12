package Level_2.Exercise_1;

import java.util.HashSet;

public class Main_4 {
    public static void main(String[] args) {
        HashSet<Restaurant_0> restaurantSet = new HashSet<>();

        // Adding restaurants
        restaurantSet.add(new Restaurant_0("Pizza Palace", 5));
        restaurantSet.add(new Restaurant_0("Burger Shack", 4));
        restaurantSet.add(new Restaurant_0("Pizza Palace", 3));  // Same name, different rating
        restaurantSet.add(new Restaurant_0("Sushi Spot", 5));
        restaurantSet.add(new Restaurant_0("Pizza Palace", 5));  // Duplicate name and rating

        // Displaying all the restaurants
        for (Restaurant_0 restaurant : restaurantSet) {
            System.out.println(restaurant);
        }
    }
}
