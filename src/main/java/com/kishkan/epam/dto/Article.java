package com.kishkan.epam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

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
