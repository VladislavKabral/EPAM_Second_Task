package by.epam.xml_task.entity;

import java.util.ArrayList;
import java.util.List;

public class Gems {

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
