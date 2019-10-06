package com.kishkan.epam.service;

import com.kishkan.epam.dto.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class ArticleUnmarshallerImpl implements ArticleUnmarshaller {
    public void unmarshalArticle(String source) throws XMLStreamException, JAXBException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StreamSource(source));

        xmlStreamReader.nextTag();
        while(!xmlStreamReader.getLocalName().equals("category")) {
            xmlStreamReader.nextTag();
        }

        JAXBContext context = JAXBContext.newInstance(Category.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<Category> element = unmarshaller.unmarshal(xmlStreamReader, Category.class);
        Category category = element.getValue();

        xmlStreamReader.close();
        System.out.println(category);
    }
}
