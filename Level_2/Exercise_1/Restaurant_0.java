package Level_2.Exercise_1;

import java.util.Objects;

public class Restaurant_0 {
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

    // Updated toString method for better output formatting
    @Override
    public String toString() {
        return String.format("Restaurant: %-15s | Rating: %d", name, rating);
    }
}
