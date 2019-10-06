package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "subcategory")
@XmlRootElement
public class Subcategory {
    private String name;
    private List<Article> articles = new ArrayList<>();
}
