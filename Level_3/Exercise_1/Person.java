package Level_3.Exercise_1;

public class Person {
    private String name;
    private String surname;
    private String dni;

    public Person(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s", name, surname, dni);
    }
}
