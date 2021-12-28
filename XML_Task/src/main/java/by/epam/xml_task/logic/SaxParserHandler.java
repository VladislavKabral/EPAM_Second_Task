package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Diamond;
import by.epam.xml_task.entity.Gem;
import by.epam.xml_task.entity.Origin;
import by.epam.xml_task.entity.Pearl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {

    private final static Logger LOGGER = LogManager.getLogger(SaxParserHandler.class);
    private String tmpTag;
    private Gem currentGem;
    private List<Gem> gems = new ArrayList<>();
    private static final String TAG_DIAMOND = "diamond";
    private static final String TAG_PEARL = "pearl";
    private static final String TAG_COLOR = "color";
    private static final String TAG_COUNT_OF_EDGES = "countOfEdges";
    private static final String TAG_RADIUS = "radius";

    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int idPosition = 0;
        int originPosition = 1;
        int amountOfAttributes = 2;
        if (TAG_DIAMOND.equals(qName) || TAG_PEARL.equals(qName)) {
            currentGem = TAG_DIAMOND.equals(qName) ? new Diamond() : new Pearl();
            currentGem.setId(attributes.getValue(idPosition));
            if (attributes.getLength() == amountOfAttributes) {
                String textOrigin = attributes.getValue(originPosition).toUpperCase();
                Origin origin = Origin.valueOf(textOrigin);
                currentGem.setOrigin(origin);
            }
        } else {
            tmpTag = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (TAG_DIAMOND.equals(qName)) {
            gems.add(currentGem);
        }
        if (TAG_PEARL.equals(qName)) {
            gems.add(currentGem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (tmpTag != null) {
            switch (tmpTag) {
                case TAG_COLOR:
                    currentGem.setColor(data);
                    break;
                case TAG_COUNT_OF_EDGES:
                    int countOfEdges = Integer.parseInt(data);
                    ((Diamond) currentGem).setCountOfEdges(countOfEdges);
                    break;
                case TAG_RADIUS:
                    int radius = Integer.parseInt(data);
                    ((Pearl) currentGem).setRadius(radius);
                    break;
                default:
                    tmpTag = null;
            }
        }
        tmpTag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("Parsing ended");
    }
}
