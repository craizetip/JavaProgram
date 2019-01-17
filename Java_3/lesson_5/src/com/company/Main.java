package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static final int CARS_COUNT = 4;//Количество машин учавствующих в гонке
    public static Semaphore smp = new Semaphore(CARS_COUNT / 2);			// Контроль прохождения туннеля
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT);        // Контроль начала гонки
    public static CountDownLatch finalCdl = new CountDownLatch(1);
    public static int prizePlaces = 1;			// Количество призовых мест
    public static CountDownLatch outerCDL = new CountDownLatch(CARS_COUNT);	// Контроль завершения гонки

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cdl.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            outerCDL.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
