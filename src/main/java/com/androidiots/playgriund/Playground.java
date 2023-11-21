package com.androidiots.playgriund;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playground {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s= "Shashank";
        s = s+ "S";
        System.out.println(s);

        ArrayList<Integer> list = new ArrayList<>();
    //System.in is a standard input stream
        while (sc.hasNext()){
            int a = sc.nextInt();
            if(a == 42){
                break;
            } else {
                list.add(a);
            }
        }
        for (int a : list){
            System.out.println(a);
        }
    }

    List<A> getList(){
        List<A> listOfA = new ArrayList<>();
        A a1 = new A();
        a1.setKey("key1");
        a1.setValue(12);
        listOfA.add(a1);
        return listOfA;
    }
}

class A<T>{
    String key;
    T value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
