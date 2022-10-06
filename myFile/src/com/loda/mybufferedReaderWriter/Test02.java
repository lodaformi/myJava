package com.loda.mybufferedReaderWriter;

import java.io.*;

public class Test02 {
    public static void main(String[] args) throws IOException {
        Reader r = new FileReader("D:\\Develop\\myJavaProjects\\myFile\\src\\com\\loda\\serial\\Person.java");
        BufferedReader br = new BufferedReader(r);

        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }

        br.close();
    }
}
