package com.company;

public class ABC{

    private static String statusFlag;	// Метка монитора

    // Получить статус флаг монитора
    public synchronized static void getStatusFlag(String threadName) {
        // Пока статус флаг и имя потока не совпадают
        while (!statusFlag.equals(threadName)) {
            try {
                // Ожидать
                ABC.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Вывод имени потока
        System.out.print(threadName);
        // Смена статус флага в зависимости от вызывающего потока
        //Вот этот момент с SWITCH мне подсказали и я его не до конца понимаю
        //подскажите в кометнтарии к ДЗ
        switch(threadName) {
            case "A":
                statusFlag = "B";
                break;
            case "B":
                statusFlag = "C";
                break;
            case "C":
                statusFlag = "A";
                break;
            default:
        }
        // Оповещение других потоков о изменениях
        ABC.class.notifyAll();
    }
    // Установка значения статус флага
    public synchronized static void setStatusFlag(String statusFlag) {
       ABC.statusFlag = statusFlag;
    }

}