package com.kishkan.epam.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class ArticleUnmarshallerImpl<T> {
    private T valueClass;

//    public ArticleUnmarshallerImpl(T valueClass) {
//        this.valueClass = valueClass;
//    }

    public <T> void unmarshalArticle(String source) throws XMLStreamException, JAXBException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StreamSource(source));

        xmlStreamReader.nextTag();
        while(!xmlStreamReader.getLocalName().equals("category")) {
            xmlStreamReader.nextTag();
        }

        JAXBContext context = JAXBContext.newInstance(valueClass.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<T> element = (JAXBElement<T>) unmarshaller.unmarshal(xmlStreamReader, valueClass.getClass());
        T dto = element.getValue();

        xmlStreamReader.close();
        System.out.println(dto);
    }
}
