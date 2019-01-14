package run.game;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.T;

public class Main {

    public static void main(String[] args) {
     System.out.println("Задача №1");
        String[] arr_z1 = {"_  1  _", "_  2  _", "_  3  _", "_  4  _", "_  5  _"};
        lis_1(arr_z1);
        for (int i = 0; i < arr_z1.length; i++) {
            System.out.println(arr_z1[i]);

        }
        System.out.println("Задача №2");
        Integer[] arr_z2i = {1, 2, 3, 4, 5};
        Double[] arr_2d = {1.1, 2.2, 3.3, 4.4, 5.5};
        L2<Integer> l2 = new L2(arr_z2i);
        L2<Double> d2 = new L2(arr_2d);

        System.out.println(lis_2(l2));
        System.out.println(lis_2(d2));

        System.out.println("Задача №3");
        Box<Apple> boxAppl_1 = new Box<>(22);
        Box<Apple> boxAppl_2 = new Box<>(10);
        Box<Apple> boxAppl_3 = new Box<>(20);
        Box<Apple> boxOrange_1 = new Box<>(10);
        Box<Apple> boxOrange_2 = new Box<>(10);
        System.out.println(boxAppl_2.compare(boxOrange_1));
    }

    public static void lis_1(String[] arrStr){
        String s;
        for (int i = 0; i < arrStr.length - 1;) {
            s = arrStr[i];
            arrStr[i] = arrStr[i + 1];
            arrStr[i + 1] = s;
            i = i + 2;
        }

    }

    public static ArrayList lis_2 (L2<?> arr){
        ArrayList list = new ArrayList();
        for (int i = 0; i < arr.getArr().length ; i++) {
            list.add(arr.getArr()[i]);
        }
        return list;
    }

    public static class L2<T>{
        private T[] arr;
        public L2(T[] arr){
            this.arr = arr;
        }
        public T[] getArr() {
            return arr;
        }
    }
}