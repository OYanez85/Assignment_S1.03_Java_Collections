package Level_2.Exercise_2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
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
    public int compareTo(Restaurant other) {
        return Integer.compare(this.rating, other.rating);  // Sort by rating
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %-15s | Rating: %d", name, rating);
    }
}
