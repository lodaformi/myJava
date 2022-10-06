package com.loda.serial;

import com.loda.*;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        outObj();
        inObj();

    }

    public static void inObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c.txt"));
        Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();
        Person p3 = (Person) ois.readObject();

        p1.equals(p2);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        ois.close();
    }

    public static void outObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c.txt"));

        Person p1 = new Person("tom", 12);
        Person p2 = new Person("jerry", 15);
        Person p3 = new Person("mike",18);

        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);

        oos.close();
    }
}
