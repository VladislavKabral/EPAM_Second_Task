package by.epam.xml_task.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(namespace = "http://www.example.com/gems", name = "gems")
@XmlAccessorType(XmlAccessType.FIELD)
public class Gems {
    @XmlElements({
            @XmlElement(name = "diamond", namespace = "http://www.example.com/gems", type = Diamond.class, required = false),
            @XmlElement(name = "pearl", namespace = "http://www.example.com/gems", type = Pearl.class, required = false) })

    private List<Gem> gemsList = new ArrayList<>();

    public List<Gem> getGemsList() {
        return gemsList;
    }

    public void setGemsList(List<Gem> gemsList) {
        this.gemsList = gemsList;
    }

    @Override
    public String toString() {
        return "Gems[" +
                "gems=" + gemsList +
                ']';
    }
}
