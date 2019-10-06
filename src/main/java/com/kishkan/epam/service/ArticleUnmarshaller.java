package com.kishkan.epam.service;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public interface ArticleUnmarshaller {
    void unmarshalArticle(String source) throws XMLStreamException, JAXBException;
}
