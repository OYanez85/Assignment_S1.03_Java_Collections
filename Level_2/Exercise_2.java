import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Restaurant_1 implements Comparable<Restaurant_1> {
    private String name;
    private int rating;

    public Restaurant_1(String name, int rating) {
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
    public int compareTo(Restaurant_1 other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison == 0) {
            return Integer.compare(other.rating, this.rating); // Sort by rating in descending order
        }
        return nameComparison; // Sort by name in ascending order
    }
}

class Main_5 {
    public static void main(String[] args) {

        List<Restaurant_1> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant_1("Pizza Palace", 8));
        restaurants.add(new Restaurant_1("Burger Shack", 7));
        restaurants.add(new Restaurant_1("Pizza Palace", 7));
        restaurants.add(new Restaurant_1("Sushi Spot", 9));
        restaurants.add(new Restaurant_1("Burger Shack", 9));

        // Sort restaurants by name and rating (descending)
        Collections.sort(restaurants);

        System.out.println("Sorted Restaurants by name and rating (descending):");
        for (Restaurant_1 restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}

