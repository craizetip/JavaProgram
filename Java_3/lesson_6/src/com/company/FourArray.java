package com.company;

import java.util.ArrayList;

public class FourArray {
    public static int[] repacking(int ar[]){
        ArrayList<Integer> list = new ArrayList<>();
        // константа наличия 4 в массиве
        int cst = ar.length;
        //перезаписываем массив в лист
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 4) {
                //если в массиве есть 4 то очищаем лист и продолжаем записывать дальше
                list.clear();
                //обнуляем константу если есть нашли 4 в массиве
                cst = 0;
            } else {
                list.add(ar[i]);
            }
        }
        try {
            //если cst != 0 то в массиве не нашли 4 по ТЗ это Исключение
            if(cst != 0) throw new RuntimeException();
        }catch (RuntimeException re){
            //При выбрасывание исключения уведомляем об этом в консоль и очищаем Лист
            System.out.print("Исключение ты забыл в массив добавить цифорку --  4  --");
            list.clear();
        }
        int arr[] = new int[list.size()];
        //Перезаписываем массив без 4
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        //Выводим новый массив
        return arr;
    }
}
