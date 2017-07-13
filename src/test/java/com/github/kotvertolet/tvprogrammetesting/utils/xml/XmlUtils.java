package com.github.kotvertolet.tvprogrammetesting.utils.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by kotvertolet on 7/12/2017.
 */
public class XmlUtils {

    public static <T> T mapXmlOnObject(String xml, Class<T> clazz) {
        StringReader reader = new StringReader(xml);
        JAXBContext jaxbContext;
        Unmarshaller unmarshaller;
        T person = null;
        try {
            jaxbContext = JAXBContext.newInstance(clazz);
            unmarshaller = jaxbContext.createUnmarshaller();
            person = (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static String removeXmlDeclarationAndDocType(String xml) {
        return xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!DOCTYPE tv SYSTEM \"xmltv.dtd\">", "");
    }

}
