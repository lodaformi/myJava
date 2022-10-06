package com.loda.myStringBuilder;

public class Demo01 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");

        System.out.println(sb1 ==  sb2);
        System.out.println(sb1);
        System.out.println(sb1.toString().equals(sb2.toString()));

        StringBuilder sb3 = new StringBuilder();
        sb3.append("[");
        int[] arr = {4,3,2,10};
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                sb3.append(arr[i]).append("]");
            }else {
                sb3.append(arr[i]).append(",");
            }
        }
        System.out.println(sb3);

        String s1 = "hello";
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i)+"\t");
        }
        System.out.println();
    }
}
