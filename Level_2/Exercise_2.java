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

    
    @Override
    public String toString() {
        return "Restaurant{name='" + name + "', rating=" + rating + "}";
    }

    
    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison == 0) {
            
            return Integer.compare(other.rating, this.rating);
        }
        return nameComparison;
    }
}

public class Main {
    public static void main(String[] args) {
        
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Pizza Palace", 8));
        restaurants.add(new Restaurant("Burger Shack", 7));
        restaurants.add(new Restaurant("Pizza Palace", 7));
        restaurants.add(new Restaurant("Sushi Spot", 9));
        restaurants.add(new Restaurant("Burger Shack", 9));

        
        Collections.sort(restaurants);

        
        System.out.println("Sorted Restaurants by name and rating (descending):");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
