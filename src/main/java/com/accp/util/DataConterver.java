package com.accp.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转换
 */
public class DataConterver  implements Converter<String,Date> {

    private String dataPatter;

    public void setDataPatter(String dataPatter) {
        this.dataPatter = dataPatter;
    }

    public Date convert(String s) {
        Date date = null;
        try {
            date = new SimpleDateFormat(dataPatter).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
