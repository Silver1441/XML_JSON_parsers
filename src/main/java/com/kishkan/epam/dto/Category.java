package com.kishkan.epam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "article")
@Setter
@Getter
public class Category {
    @XmlAttribute(name = "name")
    private String name;
    private List<Subcategory> subcategories = new ArrayList<>();
}
