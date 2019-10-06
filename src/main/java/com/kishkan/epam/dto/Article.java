package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "article")
public class Article {
    @XmlAttribute(name = "id")
    private long ID;
    @XmlAttribute(name = "stock")
    private int stock;
    @XmlElement(name = "manufacturer")
    private String manufacturer;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "production_date")
    private String productionDate;
    @XmlElement(name = "color")
    private String color;
    @XmlElement(name = "price")
    private Double price;
}
