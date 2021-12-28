package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Gem;

import java.util.List;

public interface Parser {

    List<Gem> parse(String filePath) throws ParserException;
}
