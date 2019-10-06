package com.kishkan.epam.service;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XmlValidator {
    public static boolean validateXml(String xml, String xsdPath) throws IOException {
        try {
            File xsd = new File(xsdPath);
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(new StringReader(xml)));
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
