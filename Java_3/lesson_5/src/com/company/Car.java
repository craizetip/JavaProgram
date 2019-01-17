package com.company;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private Race race;				// Трасса
    private int speed;				// Скорость
    private String name;			// Имя
    private static int CARS_COUNT;	// Количество машин

    static {						// Счётчик создаваемых классов
        CARS_COUNT = 0;
    }

    public Car(Race race, int speed) {	// Конструктор
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник №" + CARS_COUNT;
    }

    // Получить значение скорости
    public int getSpeed() {
        return speed;
    }

    // Получить значение имени
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));

            System.out.println(this.name + " готов");
            Main.cdl.countDown();//Как выполняется подготовка уменьшаем счетчик
            Main.cdl.await();//Все машины стартуют одновременно

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) { //Прохождение трассы потоком
            race.getStages().get(i).go(this);
        }
        Main.finalCdl.countDown();							// Отмечает каждого кто финишировал

        try {
            Main.finalCdl.await();							// Снимает блокировку для каждого финишировавшего
            if (Main.prizePlaces > 0) {						// Сообщение о том, кто пришёл первым
                Main.prizePlaces--;
                System.out.println(Thread.currentThread().getName() + " WIN.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Main.outerCDL.countDown();							// Ожидание потоком main завершения работы всех
        // остальных потоков
    }
}
