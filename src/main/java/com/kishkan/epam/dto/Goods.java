package com.kishkan.epam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

@XmlType(name = "article")
@Setter
@Getter
public class Goods {
    @XmlAttribute
    private final long ID;
    private String manufacturer;
    private String model;
    private LocalDate productionDate;
    private String color;
    private Double price;

    public Goods(long id) {
        this.ID = id;
    }
}
