package com.kishkan.epam.service;

import com.google.gson.Gson;

import javax.xml.bind.JAXBException;

public class JsonToXmlConverter {
    public <T> String convertJsonToXml(String json, Class<T> classValue) throws JAXBException {
        XmlMarshaller xmlMarshaller = new XmlMarshaller();
        Gson gson = new Gson();
        T value = gson.fromJson(json, classValue);

        String resultXml = xmlMarshaller.marshalXml(value);
        return resultXml;
    }

}
