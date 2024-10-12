package Level_2.Exercise_1;
import java.util.HashSet;
import java.util.Objects;

class Restaurant_0 {
    private String name;
    private int rating;

    public Restaurant_0(String name, int rating) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant_0 that = (Restaurant_0) o;
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

class Main_4 {
    public static void main(String[] args) {

        HashSet<Restaurant_0> restaurantSet = new HashSet<>();

        // Adding restaurants
        restaurantSet.add(new Restaurant_0("Pizza Palace", 5));
        restaurantSet.add(new Restaurant_0("Burger Shack", 4));
        restaurantSet.add(new Restaurant_0("Pizza Palace", 3)); // Same name, different rating
        restaurantSet.add(new Restaurant_0("Sushi Spot", 5));
        restaurantSet.add(new Restaurant_0("Pizza Palace", 5)); // Duplicate, should not be added

        // Corrected for loop
        for (Restaurant_0 restaurant : restaurantSet) {
            System.out.println(restaurant); // Printing the restaurant object
        }
    }
}

