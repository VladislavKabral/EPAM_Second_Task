package by.epam.xml_task.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "diamond")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diamond extends Gem{

    @XmlElement(name = "countOfEdges", namespace = "http://www.example.com/gems")
    private int countOfEdges;

    public Diamond() {
    }

    public Diamond(String id, String color, Origin origin, int countOfEdges) {
        super(id, color, origin);
        this.countOfEdges = countOfEdges;
    }

    public int getCountOfEdges() {
        return countOfEdges;
    }

    public void setCountOfEdges(int countOfEdges) {
        this.countOfEdges = countOfEdges;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Diamond diamond = (Diamond) object;
        return countOfEdges == diamond.countOfEdges && (getId().equals(diamond.getId()))
                                                    && (getColor().equals(diamond.getColor()))
                                                    && (getOrigin().equals(diamond.getOrigin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode())
                                + ((getColor() == null) ? 0 : getColor().hashCode()
                                + ((getOrigin() == null) ? 0 : getOrigin().toString().hashCode())
                                + this.countOfEdges);
        return result;
    }

    @Override
    public String toString() {
        return "Diamond[" +
                "id=" + getId() + " " +
                "color=" + getColor() + " " +
                "origin=" + getOrigin().toString() + " " +
                "countOfEdges=" + countOfEdges +
                ']';
    }
}
