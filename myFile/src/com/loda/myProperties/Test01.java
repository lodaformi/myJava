package com.loda.myProperties;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) throws IOException {
        Properties pp = new Properties();
        InputStream is = new FileInputStream("src/com/loda/myProperties/db.properties");
        pp.load(is);

//        for (Object o : pp.keySet()) {
//            System.out.println(o + "---" + pp.getProperty((String) o));
//        }
//
//        for (Map.Entry<Object, Object> entry : pp.entrySet()) {
//            System.out.println(entry.getKey() + "---" + entry.getValue());
//        }
//
//        for (String key : pp.stringPropertyNames()) {
//            System.out.println(key + "---" + pp.getProperty(key));
//        }

        pp.setProperty("add", "shanghai");
        pp.setProperty("profession","pm");
        pp.put("mgr","mike");

        OutputStream os = new FileOutputStream("db2.properties");
        pp.store(os, "new config");

        is.close();
    }
}
