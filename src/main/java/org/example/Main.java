package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("{}"));//T
        System.out.println(isValid("{)"));//F
        System.out.println(isValid("{}()"));//T
        System.out.println(isValid(""));//T
        System.out.println(isValid("(([[]]))"));//T
        System.out.println(isValid("{[[((()))]]}"));//T
        System.out.println(isValid("{}()(([)]))"));//F
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();

        String[] array = s.split("");

        if(s.equals("")){
            return true;
        }
        if(array[0].equals(")") || array[0].equals("}") || array[0].equals("]")){
            return false;
        }

        for(int i = 0; i < array.length; i++){
            if(Objects.equals(array[i], "{") || Objects.equals(array[i], "(") || Objects.equals(array[i], "[")){
                stack.push(array[i]);
            }else {
                if(stack.empty()){
                    return false;
                }
                if(stack.peek().equals("{") && array[i].equals("}")){
                    stack.pop();
                }else if(stack.peek().equals("(") && array[i].equals(")")){
                    stack.pop();
                }else if(stack.peek().equals("[") && array[i].equals("]")){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        System.out.println(stack);

        return false;
    }

}