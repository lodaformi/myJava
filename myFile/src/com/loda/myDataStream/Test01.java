package com.loda.myDataStream;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
//        outData();
        inData();
    }

    public static void outData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/a.txt"));
        String name = "tony";
        int age = 25;
        double sal = 8000;
        dos.writeUTF(name);
        dos.writeInt(age);
        dos.writeDouble(sal);

        dos.close();
    }

    public static void inData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("src/a.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        double sal = dis.readDouble();

        System.out.println(name+" : " + age +" : " + sal);
        dis.close();
    }
}
