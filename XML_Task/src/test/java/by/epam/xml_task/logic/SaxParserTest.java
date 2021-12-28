package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Diamond;
import by.epam.xml_task.entity.Gem;
import by.epam.xml_task.entity.Origin;
import by.epam.xml_task.entity.Pearl;
import by.epam.xml_task.factoty.ParserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SaxParserTest {
    private static final String XML_FILE_PATH = "src/main/resources/gems.xml";
    private static final List<Gem> EXPECTED_GEMS = Arrays.asList(new Diamond("GEM12345","red", Origin.UNDERGROUND , 9),
                                                         new Diamond("GEM12346", "green", Origin.UNDERWATER, 10),
                                                         new Diamond("GEM12347", "blue", Origin.MOUNTAIN, 7),
                                                         new Pearl("GEM98765", "white", Origin.UNDERWATER, 7),
                                                         new Pearl("GEM98764", "pink", Origin.UNDERWATER, 5),
                                                         new Pearl("GEM98763", "white", Origin.UNDERWATER, 9));

    @Test
    public void testSaxParserShouldReturnEntitiesFromXmlFileWhenXmlFileValid() throws ParserException {
        //given
        ParserFactory factory = new ParserFactory();
        SaxParser parser = (SaxParser) factory.create(ParserType.SAX_PARSER);

        //when
        List<Gem> actualGems = parser.parse(XML_FILE_PATH);

        //then
        Assert.assertEquals(EXPECTED_GEMS, actualGems);
    }
}
