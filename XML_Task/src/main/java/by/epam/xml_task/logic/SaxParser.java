package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Gem;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser{

    @Override
    public List<Gem> parse(String filePath) throws ParserException {
        SaxParserHandler handler = new SaxParserHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(filePath);
        } catch (SAXException | IOException | ParserConfigurationException exception) {
            throw new ParserException(exception.getMessage(), exception);
        }
        return handler.getGems();
    }
}
