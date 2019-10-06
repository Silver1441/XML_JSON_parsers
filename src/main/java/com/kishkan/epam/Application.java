package com.kishkan.epam;

import com.kishkan.epam.dto.Article;
import com.kishkan.epam.service.XmlUnmarshaller;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Application {

    public static void main(String[] args) {
        XmlUnmarshaller articleUnmarshaller = new XmlUnmarshaller();
        String source = "src/main/resources/xml/mock_product_list.xml";

        try {
            Article article = articleUnmarshaller.unmarshalXml(source, new Article(), 100101L);
            System.out.println(article);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

    }
}
