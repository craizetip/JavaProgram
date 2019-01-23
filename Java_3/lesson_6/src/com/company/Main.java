package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        OneAndFour oan = new OneAndFour();
        int arr1[] = new int[]{1,2,3,4,5,6,7,8,9};
        int arr2[] = new int[]{1, 1, 4, 5, 3, 4, 1, 5, 3, 4};
        int arr3[] = new int[]{1,2,3,3,5,6,7,9};
        int arr4[] = new int[]{4,2,3,3,5,6,7,4,9};
        System.out.println(oan.check(arr1));
        System.out.println(oan.check(arr2));
        System.out.println(oan.check(arr3));
        System.out.println(oan.check(arr4));
    }

}
