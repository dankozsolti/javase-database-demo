package hu.ulyssys.java.course.database.jdbc;

public class Dog {
    private Long id;
    private String name;
    private String color;
    private String species;

    public Dog() {
    }

    public Dog(Long id, String name, String color, String species) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
