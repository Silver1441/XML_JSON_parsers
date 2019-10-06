package com.kishkan.epam.service;

import com.kishkan.epam.dto.DtoHasLocalName;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class XmlUnmarshaller {

    public <T extends DtoHasLocalName> T unmarshalXmlById(String source, T valueClass, Long id)
            throws XMLStreamException, JAXBException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StreamSource(source));

        xmlStreamReader.nextTag();

        while(xmlStreamReader.hasNext()){
            xmlStreamReader.next();
            if(xmlStreamReader.getEventType() == XMLStreamReader.START_ELEMENT
                    && xmlStreamReader.getAttributeValue(0) != null
                    && xmlStreamReader.getAttributeValue(0).equals(id.toString())
                    && xmlStreamReader.getLocalName().equals(valueClass.getLocalName())){
                break;
            }
        }

        xmlStreamReader.isWhiteSpace();

        Unmarshaller unmarshaller = JAXBContext.newInstance(valueClass.getClass()).createUnmarshaller();
        JAXBElement<? extends DtoHasLocalName> element = unmarshaller.unmarshal(xmlStreamReader, valueClass.getClass());
        T dto = (T) element.getValue();

        xmlStreamReader.close();
        return dto;
    }
}