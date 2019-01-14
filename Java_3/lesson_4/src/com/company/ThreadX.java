package com.company;

public class ThreadX extends Thread {

    private int count = 5; // Счётчик выполнения задания
    // Конструктор потока
    public ThreadX(String name) {
        // Установка имени потока
        this.setName(name);
        // Сообщение о запуске потока
        System.out.println("Thread " + getName() + " start.");
    }
    // Переопределение метода run
    @Override
    public void run() {
        // Бесконечный цикл опрашивающий состояние статус флага монитора
        while(count > 0) {
            ABC.getStatusFlag(getName());
            count--;
        }
    }
}