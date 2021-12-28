package by.epam.xml_task.logic;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    private static final String VALID_GEMS_FILE_PATH = "src/main/resources/gems.xml";
    private static final String INVALID_GEMS_FILE_PATH = "src/main/resources/invalidGems.xml";
    private static final String GEMS_SCHEMA_FILE_PATH = "src/main/resources/gemsSchema.xsd";

    @Test
    public void testXmlValidatorShouldReturnTrueWhenXmlFileValid() {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean actualValidation = validator.validate(VALID_GEMS_FILE_PATH, GEMS_SCHEMA_FILE_PATH);

        //then
        Assert.assertTrue(actualValidation);
    }

    @Test
    public void testXmlValidatorShouldReturnFalseWhenXmlFileInvalid() {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean actualValidation = validator.validate(INVALID_GEMS_FILE_PATH, GEMS_SCHEMA_FILE_PATH);

        //then
        Assert.assertFalse(actualValidation);
    }
}
