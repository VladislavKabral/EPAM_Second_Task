package by.epam.xml_task.entity;

public class Pearl extends Gem{

    private int radius;

    public Pearl() {

    }

    public Pearl(String id, String color, Origin origin, int radius) {
        super(id, color, origin);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Pearl pearl = (Pearl) object;
        return radius == pearl.radius && (getId().equals(pearl.getId()))
                                      && (getColor().equals(pearl.getColor()))
                                      && (getOrigin().equals(pearl.getOrigin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode())
                                + ((getColor() == null) ? 0 : getColor().hashCode())
                                + ((getOrigin() == null) ? 0 : getOrigin().toString().hashCode())
                                + this.radius;
        return result;
    }

    @Override
    public String toString() {
        return "Pearl[" +
                "id=" + getId() +
                "color=" + getColor() +
                "origin=" + getOrigin().toString() +
                "radius=" + radius +
                ']';
    }
}
