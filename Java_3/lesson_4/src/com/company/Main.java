package com.company;



public class Main extends Thread {

    public static void main(String[] args) {

        ThreadX a = new ThreadX("A");
        ThreadX b = new ThreadX("B");
        ThreadX c = new ThreadX("C");

        ABC.setStatusFlag("A");
        a.start();
        b.start();
        c.start();
    }
}