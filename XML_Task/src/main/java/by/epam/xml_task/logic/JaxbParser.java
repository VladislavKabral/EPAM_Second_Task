package by.epam.xml_task.logic;

import by.epam.xml_task.entity.Gem;
import by.epam.xml_task.entity.Gems;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbParser implements Parser{
    @Override
    public List<Gem> parse(String filePath) throws ParserException {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Gems.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Gems gems = (Gems) jaxbUnmarshaller.unmarshal(new File(filePath));
            return gems.getGemsList();
        } catch (JAXBException exception) {
            throw new ParserException(exception.getMessage(), exception);
        }
    }
}
