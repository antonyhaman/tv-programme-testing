package com.github.kotvertolet.tvprogrammetesting.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kotvertolet on 7/13/2017.
 */
public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    private final static DateTimeFormatter GENERIC_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(LocalDateTime dt) throws Exception {
        return dt.toString();
    }

    @Override
    public LocalDateTime unmarshal(String str) throws Exception {
        return LocalDateTime.parse(str, GENERIC_FORMAT);
    }
}