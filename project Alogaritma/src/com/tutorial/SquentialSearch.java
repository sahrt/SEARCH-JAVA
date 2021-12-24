package com.tutorial;

import java.util.Scanner;

public class SquentialSearch {
    public static void main(String[] args) {
        System.out.println("=== Program Mencari angka ===");
        System.out.println("{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}");
        Scanner input = new Scanner(System.in);
        System.out.print("masukan yang ingin dicari: ");
        int cari= input.nextInt();
        int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int index = 0;
        System.out.println("hasil yang dicari yaitu indeks ke - " + squenstialSearch(array,cari));
        System.out.println(" ");
        System.out.println("metode rekursif");
        System.out.println("hasil yang dicari yaitu indeks ke - "+ squensialSearch1(array,index,cari));
        System.out.println("====== program selesai guys ======");
    }

    private static int squenstialSearch(int [] array, int x) {
        System.out.println("methode iterative");
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
              return i;
            }
        }
        return -1;

    }
    private static int squensialSearch1 (int [] array,int i, int x){
        if (i < array.length){
            if(x == array [i]){
              return i;
            } else{
                return squensialSearch1 (array, i+1, x);
            }
        }
        return -1;
    }
}


