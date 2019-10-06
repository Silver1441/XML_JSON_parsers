package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "category")
public class Category {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "subcategory")
    private List<Subcategory> subcategories;
}
