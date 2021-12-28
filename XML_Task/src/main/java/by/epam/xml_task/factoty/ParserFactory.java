package by.epam.xml_task.factoty;

import by.epam.xml_task.logic.*;

public class ParserFactory {

    public Parser create(ParserType parserType) throws ParserException {
        switch (parserType) {
            case DOM_PARSER:
                return new DomParser();
            case SAX_PARSER:
                return new SaxParser();
            case JAXB_PARSER:
                return new JaxbParser();
            default:
                throw new ParserException("Invalid parser type");
        }
    }
}
