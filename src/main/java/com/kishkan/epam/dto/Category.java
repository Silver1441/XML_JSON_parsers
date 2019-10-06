package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "category")
public class Category extends DtoHasLocalName {
    @XmlAttribute(name = "id")
    private long id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "subcategory")
    private List<Subcategory> subcategories;

    @Override
    public String getLocalName() {
        return "category";
    }

    @Override
    public String toString() {
        return "\nCategory:" +
                "\n{name = " + name + "\nID = " + id +
                "\nsubcategories:" + subcategories +
                '}';
    }
}
