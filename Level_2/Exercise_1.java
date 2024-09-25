import java.util.HashSet;
import java.util.Objects;

class Restaurant {
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

    // Override equals and hashCode to prevent duplicate name and rating in HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return rating == that.rating && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }

    @Override
    public String toString() {
        return "Restaurant{name='" + name + "', rating=" + rating + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a HashSet to store Restaurant objects
        HashSet<Restaurant> restaurantSet = new HashSet<>();

        // Add restaurants to the set
        restaurantSet.add(new Restaurant("Pizza Palace", 5));
        restaurantSet.add(new Restaurant("Burger Shack", 4));
        restaurantSet.add(new Restaurant("Pizza Palace", 3)); // Same name, different rating
        restaurantSet.add(new Restaurant("Sushi Spot", 5));
        restaurantSet.add(new Restaurant("Pizza Palace", 5)); // Duplicate, should not be added

        // Display the contents of the HashSet
        for (Restaurant restaurant : restaurantSet) {
            System.out.println(restaurant);
        }
    }
}
