package com.kishkan.epam;

import com.kishkan.epam.dto.Article;
import com.kishkan.epam.dto.Category;
import com.kishkan.epam.dto.Subcategory;
import com.kishkan.epam.service.XmlMarshaller;
import com.kishkan.epam.service.XmlToJsonConverter;
import com.kishkan.epam.service.XmlUnmarshaller;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Application {

    public static void main(String[] args) {
        XmlUnmarshaller articleUnmarshaller = new XmlUnmarshaller();
        XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();
        XmlMarshaller xmlMarshaller = new XmlMarshaller();
        String source = "src/main/resources/xml/mock_product_list.xml";

        try {
            Article article = articleUnmarshaller.unmarshalXmlById(source, Article.class, 200101L);
            System.out.println(article);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            Subcategory subcategory = articleUnmarshaller.unmarshalXmlById(source, Subcategory.class, 120002L);
            System.out.println(subcategory);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            Category category = articleUnmarshaller.unmarshalXmlById(source, Category.class, 110002L);
            System.out.println(category);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            String json = xmlToJsonConverter.convertSmlToJson(source, Category.class, 110002L);
            System.out.println(json);
        } catch (JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }

        try {
            Category category = articleUnmarshaller.unmarshalXmlById(source, Category.class, 110002L);
            String resultXml = xmlMarshaller.marshalXml(category);
            System.out.println(resultXml);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }


    }
}
