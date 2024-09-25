import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Restaurant implements Comparable<Restaurant> {
    private String name;
    private int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Restaurant{name='" + name + "', rating=" + rating + "}";
    }

    // Implement Comparable to sort by name, and then by rating (descending)
    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison == 0) {
            // If names are the same, compare by rating in descending order
            return Integer.compare(other.rating, this.rating);
        }
        return nameComparison;
    }
}

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a list of Restaurant objects
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Pizza Palace", 8));
        restaurants.add(new Restaurant("Burger Shack", 7));
        restaurants.add(new Restaurant("Pizza Palace", 7));
        restaurants.add(new Restaurant("Sushi Spot", 9));
        restaurants.add(new Restaurant("Burger Shack", 9));

        // Step 2: Sort the list of restaurants using Comparable's compareTo method
        Collections.sort(restaurants);

        // Step 3: Display the sorted list
        System.out.println("Sorted Restaurants by name and rating (descending):");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
