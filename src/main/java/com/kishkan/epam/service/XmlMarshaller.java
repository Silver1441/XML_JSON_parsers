package com.kishkan.epam.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlMarshaller {
    public <T> String marshalXml(T classValue) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(classValue.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(classValue, stringWriter);

        return stringWriter.toString();
    }
}
