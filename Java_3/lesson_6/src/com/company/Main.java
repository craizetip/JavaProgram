package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FourArray fa = new FourArray();

	    int arr1[] = new int[]{1,2,3,4,5,6,7,8,9};
        int arr2[] = new int[]{1,2,3,3,5,6,7,8,9};
        int arr3[] = new int[]{1,2,3,4,5,6,7,4,9};
        System.out.println("Массив 1");
        System.out.println(Arrays.toString(fa.repacking(arr1)));
        System.out.println("Массив 2");
        System.out.println(Arrays.toString(fa.repacking(arr2)));
        System.out.println("Массив 3");
        System.out.println(Arrays.toString(fa.repacking(arr3)));
        
    }

}
