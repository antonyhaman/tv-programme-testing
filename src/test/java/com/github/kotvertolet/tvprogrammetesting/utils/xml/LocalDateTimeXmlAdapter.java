package com.github.kotvertolet.tvprogrammetesting.utils.xml;

import com.github.kotvertolet.tvprogrammetesting.utils.DateTimeFormats;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public String marshal(LocalDateTime dt) throws Exception {
        return dt.toString();
    }

    @Override
    public LocalDateTime unmarshal(String str) throws Exception {
        return LocalDateTime.parse(str, DateTimeFormats.GENERIC_FORMAT);
    }
}