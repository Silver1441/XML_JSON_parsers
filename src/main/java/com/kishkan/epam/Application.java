package com.kishkan.epam;

import com.kishkan.epam.service.ArticleUnmarshaller;
import com.kishkan.epam.service.ArticleUnmarshallerImpl;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Application {

    public static void main(String[] args) {
        ArticleUnmarshaller articleUnmarshaller = new ArticleUnmarshallerImpl();
        String source = "src/main/resources/xml/mock_product_list.xml";

        try {
            articleUnmarshaller.unmarshalArticle(source);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }

    }
}
