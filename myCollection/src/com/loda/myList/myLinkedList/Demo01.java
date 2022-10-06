package com.loda.myList.myLinkedList;

import java.util.LinkedList;

public class Demo01 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        //add增加
        linkedList.add("算法");
        linkedList.add("shuju");
        linkedList.addFirst("jiekou");
        linkedList.addLast(123);
        linkedList.add(2,5.898);
        System.out.println(linkedList);

        //offer增加
//        linkedList.offer(456);          //尾插
//        linkedList.offerFirst("opq");   //头插
//        linkedList.offerLast(",../");   //尾插

        //peek 查
//        System.out.println(linkedList.peek());//头查
//        System.out.println(linkedList.peekFirst());    //头查
//        System.out.println(linkedList.peekLast());     //尾查

        //poll删除，能获取到删除的元素
//        linkedList.poll();          //头删
//        linkedList.pollFirst();     //头删
//        linkedList.pollLast();      //尾删

        //remove
        System.out.println(linkedList.remove());
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println(linkedList);
    }
}
