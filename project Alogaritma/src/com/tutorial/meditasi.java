package com.tutorial;

import java.util.Scanner;

public class meditasi {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();
        pemisah(a,b);
    }
    private static int  pemisah (int a, int b){
        if(a < b){
            return a;
        }else {
            return b;
        }
    }
}
