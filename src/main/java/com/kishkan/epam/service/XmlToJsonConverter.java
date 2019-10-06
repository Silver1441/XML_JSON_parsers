package com.kishkan.epam.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class XmlToJsonConverter {
    public <T> String convertSmlToJson(String source, Class<T> valueClass, Long id)
            throws JAXBException, XMLStreamException {

        XmlUnmarshaller articleUnmarshaller = new XmlUnmarshaller();
        T objectFromXml = articleUnmarshaller.unmarshalXmlById(source, valueClass, id);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(objectFromXml, valueClass);
    }
}
