package com.tutorial;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class binarrySearch {
    public static void main(String[] args) {
        System.out.println(" == PROGRAM JAVA PENCARIAN ANGKA ===");
        Scanner input = new Scanner(System.in);
        int[] array = {11, 23, 45, 75, 89, 12, 34, 21, 43, 63, 41, 6, 7};
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        System.out.println(" data binary seacrh harus diurutkan terlebih dahulu");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        try {
            System.out.print(" masukan angka yang dicari : ");
            int cari = input.nextInt();

            int result = binarrySearchItrative(array, cari);
            if (result == -1) {
                System.out.printf("find  %d not found", cari);
            } else {
                System.out.printf("hasil yang kamu inginkan %d ada di indeks ke %d", cari, result);
            }

            //rekrusif
            System.out.println(" \n===========================================");
            System.out.println("Secara rekursif");
            int first = 0;
            int last = array.length;


            int result1 = binarySearchRekursif(array, first, last, cari);
            if (result1 == -1) {
                System.out.printf("find  %d not found", cari);
            } else {
                System.out.printf("hasil yang kamu inginkan %d ada di indeks ke %d", cari, result1);
            }

            //PENCARIAN lOMPAT JAVA VERSI 1
            System.out.println(" \n===========================================");
            System.out.println("PENCARIAN lOMPAT JAVA VERSI 1");
            int result2 = pencarianLompatDalamJava(array, cari);
            if (result2 == -1) {
                System.out.printf("find  %d not found", cari);
            } else {
                System.out.printf("hasil yang kamu inginkan %d ada di indeks ke %d", cari, result2);
            }


            // jumpersearch with while loop
            System.out.println(" \n===========================================");
            System.out.println("PENCARIAN lOMPAT JAVA VERSI 2");
            int result3 = pencarianJumperSearchJavaVersi2(array,cari);
            if (result3 == -1) {
                System.out.printf("find  %d not found", cari);
            } else {
                System.out.printf("hasil yang kamu inginkan %d ada di indeks ke %d", cari, result3);
            }




            //jumpersearch with foor loop
            System.out.println(" \n===========================================");
            System.out.println( "jumpersearch with foor loop");
            int result4 = backwardSearch(array, cari);
            if (result4 == -1) {
                System.out.printf("find  %d not found", cari);
            } else {
                System.out.printf("hasil yang kamu inginkan %d ada di indeks ke %d", cari, result3);
            }
        } catch (Exception e) {
            System.out.println("kesalahan " + e.getMessage());
        }


    }

    private static int binarrySearchItrative(int[] array, int cari) {
        int first = 0;
        int last = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            int mid = first + (last - first) / 2;
            if (array[mid] == cari) {
                return mid;
            } else if (array[mid] > cari) {

                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRekursif(int[] array, int first, int last, int cari) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (array[mid] == cari) {
                return mid;
            } else if (array[mid] > cari) {
                return binarySearchRekursif(array, first, mid + 1, cari);
            } else {
                return binarySearchRekursif(array, mid - 1, last, cari);
            }

        }
        return -1;
    }

    private static int pencarianLompatDalamJava(int[] array, int cari) {
        int n = array.length;
        // deklarasi besarr lompatan
        int jump = (int) Math.floor(Math.sqrt(n));

        //mencari block dimana elemen berada
        //mengunaka nama kondisi disis lompat berulang ulang
        int prev = 0; //batas paling kiri array dimulai dari indeks ke 0
        while (array[Math.min(jump,n)-1] < cari){
            prev=jump;
            jump += (int)Math.floor(Math.sqrt(n));
            if (prev >= n){
                return -1;
            }
        }
        // doing a linear search for x in block
        // begininning with prey

        // looping untuk pencarian liniear
        while (array[prev] < cari) {
            prev++;

            //jika lompatan blok duah terpenuhi makas akan dilakukan pencarian linier
            // array, element is not present.

            if (prev == Math.min(jump, n)) {
                return -1;
            }
        }

            // if element is found // elemne ditemukan
            if(array[prev] == cari){
                return prev;
            }
     return -1;
    }


    private static  int min (int a, int b){
        if(a < b){
            return a;
        }else {
            return b;
        }
    }

    private static int pencarianJumperSearchJavaVersi2(int[] array, int cari) {
        // kita cetak dulu berapakah panjang lompatanya
        int n = array.length-1;
        int jump = (int) sqrt(n);
        int left = 0;
        int right = 0;
        while (left < n && array[left] <= cari) {
            right = min(n - 1, left + jump);
            if (array[left] <= cari && array[right] >= cari) {
                break;
            }
            left += jump;
        }
        if (left >= n || array[left] > cari){
            return -1;
        }
        right = min(n-1 , right);
        for (int i =left ; i <= right && array [i] <= cari; i++){
            if (array[i] == cari){
                return i;
            }


        }
        return  -1;

    }
    public static int backwardSearch(int[] array, int target) {
        int rightIncl = array.length-1;
        int leftExcl =0;
        for (int i = rightIncl; i > leftExcl; i--) {
            if (array[i] == target) {
                return 1;
            }
        }
        return -1;
    }

}

