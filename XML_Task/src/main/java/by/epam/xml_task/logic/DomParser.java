package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Diamond;
import by.epam.xml_task.entity.Gem;
import by.epam.xml_task.entity.Origin;
import by.epam.xml_task.entity.Pearl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser{

    private Gem currentGem;
    private List<Gem> gems = new ArrayList<>();
    private static final String TAG_DIAMOND = "diamond";
    private static final String TAG_PEARL = "pearl";
    private static final String TAG_COLOR = "color";
    private static final String TAG_COUNT_OF_EDGES = "countOfEdges";
    private static final String TAG_RADIUS = "radius";
    private static final String TAG_ORIGIN = "origin";
    private static final String TAG_ID = "id";

    private String getTextContentOfElement(Element element, String nameOfElement) {
        NodeList nodeList = element.getElementsByTagName(nameOfElement);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

    private void createGem(Element element, String tagName) {
        currentGem = tagName.equals(TAG_PEARL) ? new Pearl() : new Diamond();
        currentGem.setId(element.getAttribute(TAG_ID));
        if (!element.getAttribute(TAG_ORIGIN).isEmpty()) {
            String textOfOrigin = element.getAttribute(TAG_ORIGIN).toUpperCase();
            Origin origin = Origin.valueOf(textOfOrigin);
            currentGem.setOrigin(origin);
        }

        currentGem.setColor(getTextContentOfElement(element, TAG_COLOR));
        if (tagName.equals(TAG_PEARL)) {
            int radius = Integer.parseInt(getTextContentOfElement(element, TAG_RADIUS));
            ((Pearl) currentGem).setRadius(radius);
        }
        if (tagName.equals(TAG_DIAMOND)) {
            int countOfEdges = Integer.parseInt(getTextContentOfElement(element, TAG_COUNT_OF_EDGES));
            ((Diamond) currentGem).setCountOfEdges(countOfEdges);
        }
    }

    private void createListOfGems(Element root, String tagName) {
        NodeList gemsList = root.getElementsByTagName(tagName);
        for (int i = 0; i < gemsList.getLength(); i++) {
            Element element = (Element) gemsList.item(i);
            createGem(element, tagName);
            gems.add(currentGem);
        }
    }

    @Override
    public List<Gem> parse(String filePath) throws ParserException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            Element root = document.getDocumentElement();
            createListOfGems(root, TAG_DIAMOND);
            createListOfGems(root, TAG_PEARL);
        } catch (ParserConfigurationException | IOException | SAXException exception) {
            throw new ParserException(exception.getMessage(), exception);
        }
        return gems;
    }
}
