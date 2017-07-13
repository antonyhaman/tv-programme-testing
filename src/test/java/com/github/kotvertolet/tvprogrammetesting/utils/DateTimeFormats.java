package com.github.kotvertolet.tvprogrammetesting.utils;

import java.time.format.DateTimeFormatter;

public class DateTimeFormats {

    public final static DateTimeFormatter INITIAL_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a");
    public final static DateTimeFormatter GENERIC_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
