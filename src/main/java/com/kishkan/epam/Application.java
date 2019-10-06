package com.kishkan.epam;

import com.kishkan.epam.dto.Article;
import com.kishkan.epam.dto.Category;
import com.kishkan.epam.dto.Subcategory;
import com.kishkan.epam.service.XmlUnmarshaller;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Application {

    public static void main(String[] args) {
        XmlUnmarshaller articleUnmarshaller = new XmlUnmarshaller();
        String source = "src/main/resources/xml/mock_product_list.xml";

        try {
            Article article = articleUnmarshaller.unmarshalXmlById(source, new Article(), 200101L);
            System.out.println(article);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            Subcategory subcategory = articleUnmarshaller.unmarshalXmlById(source, new Subcategory(), 120002L);
            System.out.println(subcategory);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            Category category = articleUnmarshaller.unmarshalXmlById(source, new Category(), 110002L);
            System.out.println(category);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

    }
}
