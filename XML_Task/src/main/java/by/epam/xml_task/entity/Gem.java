package by.epam.xml_task.entity;

public class Gem {

    private String id;
    private String color;
    private Origin origin;

    public Gem() {

    }

    public Gem(String id, String color, Origin origin) {
        this.id = id;
        this.color = color;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Origin getOrigin() {
        return (origin == null) ? Origin.UNDERGROUND : origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Gem [" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", origin=" + origin +
                ']';
    }
}
