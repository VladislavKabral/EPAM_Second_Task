package by.epam.xml_task.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Origin {

    @XmlEnumValue(value = "underground")
    UNDERGROUND,

    @XmlEnumValue(value = "underwater")
    UNDERWATER,

    @XmlEnumValue(value = "mountain")
    MOUNTAIN
}
