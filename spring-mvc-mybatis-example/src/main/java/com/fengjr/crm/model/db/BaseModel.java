package com.fengjr.crm.model.db;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseModel {

    public void initModel() throws IllegalAccessException {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object property = field.get(this);
            if (property != null && property instanceof String) {
                String value = field.get(this).toString();
                if (StringUtils.isNotBlank(value) && value.contains("'")) {
                    field.set(this, value.replace("'", "\\'"));
                }
                if (isDateString(value)) {
                    try {
                        String timeStr = value.substring(0, value.lastIndexOf("."));
                        field.set(this, getTimeBeforeEightAgo(timeStr));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (value.equalsIgnoreCase("null")) {
                    field.set(this, "");
                }
                //2014-11-24 16:05:02.0
            }
            if (property == null) {
                field.set(this, "");
            }
        }
    }

    private boolean isDateString(String value) {
        if (StringUtils.isNotBlank(value)
                && value.length() == 21
                && value.lastIndexOf(".") == 19) {
            try {
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }


    private String getTimeBeforeEightAgo(String timeStr) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = df.parse(timeStr);
//        System.out.println("今天的日期：" + df.format(d));
//        System.out.println("8小时前的日期：" + df.format(new Date(d.getTime() - 8 * 60 * 60 * 1000)));
        return df.format(new Date(d.getTime() - 8 * 60 * 60 * 1000));
    }

    public static void main(String[] args) throws Exception {
        String timeStr = "2015-07-23 04:11:11";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = df.parse(timeStr);
        System.out.println("今天的日期：" + df.format(d));
        System.out.println("8小时前的日期：" + df.format(new Date(d.getTime() - 8 * 60 * 60 * 1000)));
    }

}
