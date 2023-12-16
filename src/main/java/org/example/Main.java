package org.example;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);

        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
//        System.out.println("First : ");
//        addTwoNumbers(listNode1, listNode2);

        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
//        System.out.println("Second: ");
//        addTwoNumbers(listNode3, listNode4);

        ListNode listNode5 = new ListNode(9);
        listNode5.next = new ListNode(9);
        listNode5.next.next = new ListNode(9);
        listNode5.next.next.next = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        listNode6.next = new ListNode(9);
        listNode6.next.next = new ListNode(9);
        listNode6.next.next.next = new ListNode(9);
        listNode6.next.next.next.next = new ListNode(9);
        listNode6.next.next.next.next.next = new ListNode(9);
        listNode6.next.next.next.next.next.next = new ListNode(9);

//        System.out.println("Third: ");
//        addTwoNumbers(listNode5, listNode6);

        System.out.println(addTwoNumbers(listNode1,listNode2)     + " : THere is the final list node \n");
        System.out.println(addTwoNumbers(listNode3,listNode4)     + " : THere is the final list node \n");
        System.out.println(addTwoNumbers(listNode6,listNode5)     + " : THere is the final list node \n");
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //stack 1
        String number1 = "";

        while(l1 != null){
            number1 = number1 + l1.val;
            l1 = l1.next;

        }

        // stack 2
        String number2 = "";

        while(l2 != null){
            number2 = number2 + l2.val;
            l2 = l2.next;
        }

        // getting together stacks

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] num1 = number1.split("");
        String[] num2 = number2.split("");
        int N = 0;

        if(num1.length > num2.length){
            for(int i = 0; i < num1.length; i++){
                System.out.println("test1");
                if(num2.length - 1 >= i){
                    System.out.println("test2");
                    if(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N >= 10)
                    {
                        System.out.println("test3");
                        arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N - 10 );
                        N = 1;
                    }
                    else {
                        System.out.println("test4");
                        arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N );
                        N = 0;
                    }
                }else {
                    if(N == 1){
                        System.out.println("test5");
                        if(Integer.parseInt(num1[i]) + N >= 10){
                            System.out.println("test6");
                            arrayList.add(Integer.parseInt(num1[i]) + N - 10 );
                        }else {
                            System.out.println("test7");
                            arrayList.add(Integer.parseInt(num1[i]) + N);
                            N = 0;
                        }
                    }else {
                        System.out.println("test8");
                        arrayList.add(Integer.parseInt(num1[i]));
                    }
                }
                if(N == 1 && i == num1.length - 1){
                    arrayList.add(1);
                }
            }
        }
        else if(num1.length < num2.length){
            System.out.println("test9");
            for(int i = 0; i < num2.length; i++){
                if(num1.length - 1 >= i){
                    System.out.println("test10");
                    if(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N >= 10)
                    {
                        System.out.println("test11");
                        arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N - 10);
                        N = 1;
                    }
                    else {
                        System.out.println("test12");
                        arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N);
                        N = 0;
                    }
                }else {
                    if(N == 1){
                        if(Integer.parseInt(num2[i]) + N >= 10){
                            System.out.println("test13");
                            arrayList.add(Integer.parseInt(num2[i]) + N - 10 );
                        }else {
                            System.out.println("test14");
                            arrayList.add(Integer.parseInt(num2[i]) + N);
                            N = 0;
                        }
                    }else {
                        System.out.println("test15");
                        arrayList.add(Integer.parseInt(num2[i]));
                    }
                }
                if(N == 1 && i == num2.length - 1){
                    arrayList.add(1);
                }
            }
        }else//num1.length == num2.length
        {
            System.out.println("test16");
            for(int i = 0; i < num1.length; i++){
                if(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N >= 10)
                {
                    System.out.println("test17");
                    arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N - 10);
                    N = 1;
                }else {
                    System.out.println("test18");
                    arrayList.add(Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + N);
                    N = 0;
                }
                if(N == 1 && i == num1.length - 1){
                    arrayList.add(1);
                }
            }
        }

        // getting final linkedList

        ListNode head;
        ListNode l3;

        head = new ListNode(arrayList.get(arrayList.size() - 1));

        if(arrayList.size() >= 1) {
            for (int i = arrayList.size() - 2; i >= 0; i--) {
                l3 = new ListNode(arrayList.get(i));
                l3.next = head;
                head = l3;
            }
        }

        return head;
    }
}
