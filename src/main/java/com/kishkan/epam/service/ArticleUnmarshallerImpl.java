package com.kishkan.epam.service;

import com.kishkan.epam.dto.Article;

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
        StreamSource xmlStream = new StreamSource(source);
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlStream);

        xmlStreamReader.nextTag();
        while(!xmlStreamReader.getLocalName().equals("article")) {
            xmlStreamReader.nextTag();
        }

        JAXBContext context = JAXBContext.newInstance(Article.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<Article> element = unmarshaller.unmarshal(xmlStreamReader, Article.class);
        Article article = element.getValue();

        xmlStreamReader.close();
        System.out.println(article);
    }
}
