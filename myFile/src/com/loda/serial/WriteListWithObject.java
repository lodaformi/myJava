package com.loda.serial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteListWithObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeList();
        readList();
    }

    public static void writeList() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new  FileOutputStream("src/list.txt"));

        Person p1 = new Person("tom", 20);
        Person p2 = new Person("jerry", 23);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        oos.writeObject(list);

        System.out.println(oos);
        oos.close();
    }

    public static void readList() throws IOException, ClassNotFoundException {
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("src/list.txt"));

        List<Person> list =  (List<Person>) ois.readObject();

        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();
    }
}
