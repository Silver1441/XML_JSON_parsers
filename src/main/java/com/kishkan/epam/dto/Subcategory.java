package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "subcategory")
public class Subcategory extends DtoHasLocalName {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "article")
    private List<Article> articles;

    @Override
    public String getLocalName() {
        return "subcategory";
    }

    @Override
    public String toString() {
        return "\nSubcategory:\n{name='" + name + '\'' +
                "\n" + articles +
                '}';
    }
}
