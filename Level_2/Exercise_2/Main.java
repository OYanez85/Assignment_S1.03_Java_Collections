package Level_2.Exercise_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running Main program...");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant A", 5));
        restaurants.add(new Restaurant("Restaurant B", 4));

        Collections.sort(restaurants);
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
