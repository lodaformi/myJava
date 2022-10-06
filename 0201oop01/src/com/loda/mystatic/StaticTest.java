package com.loda.mystatic;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.PI;

public class StaticTest {
    public static void main(String[] args) {
        Computer cp = new Computer("hp",6000,true);
        System.out.println(cp);

        System.out.println(Math.PI);
        System.out.println(PI);

        System.out.println(cp.toString());
        System.out.println(cp);
        System.out.println(cp.getClass());
        System.out.println(cp.getClass().getName());

    }

}


