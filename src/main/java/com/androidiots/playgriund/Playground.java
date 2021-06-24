package com.androidiots.playgriund;

import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
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
}
