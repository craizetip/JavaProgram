package com.company;


import javax.swing.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Домашнее Задание 2 Урока.
    public static void start() {

        MeSqlServer.connect();
    }

    public static void stop() {

        MeSqlServer.disconnect();
    }

    public static void reg(String name, String pass, String nick) {
        try {
            MeSqlServer.registr(name, pass, nick);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newName(String name, String newName) {
        try {
            MeSqlServer.reName(name, newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Домашнее задание 3 Урока
//Задание 1
    public static void log(String nick, String text) {
        File file = new File("log.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            //получаем доступ к файлу.
            String s = nick + ": " + text + "\n";
            bw.write(s);
            bw.close();
            //закрываем поток записи
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Задание 2
    public static void showLog() {//Вывод старых сообщений
        File file = new File("log.txt");

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            int lines = 0;//выведенные строки
            StringBuilder builder = new StringBuilder();//создали контейнер
            long length = file.length();// длинна файла
            length--;// последний байт
            randomAccessFile.seek(length);// установили каретку на последний символ
            for(long seek = length; seek >= 0; --seek){//делаем цикл для чтения строк
                randomAccessFile.seek(seek);//смищение каретку
                char c = (char)randomAccessFile.read();//создали ЧАР прочитав БАЙТ
                builder.append(c);// записали ЧАР в строку
                if(c == '\n'){//проверили чар на Ентр
                    builder = builder.reverse();//прочитали строку в обратном порядке
                    System.out.println(builder.toString());//вывели строку в консоль (передали в чат)
                    lines++;//++ к строке
                    builder = new StringBuilder();//обнулили строку
                    if (lines == 100){//проверяем если вывели 100 строк то прекрощаем метод
                        randomAccessFile.close();
                        builder = null;
                        break;
                    }
                }

            }








//            StringBuffer sb = new StringBuffer();long fileLength= raf.length() -1;
//            for(long failPoint = fileLength; failPoint != -1; failPoint--){
//                raf.seek(failPoint);//установили каретку
//                int readByte = raf.readByte();//считали байт
//                if (readByte == '\n') {
//                    if (readByte == fileLength){
//                        continue;
//                    }break;
//                }
//                if (readByte == '\r') {
//                    if (readByte == fileLength -1){
//                        continue;
//                    }break;
//                }
//                sb.append((char) readByte);
//                String lastLine = sb.reverse().toString();
//                System.out.println(lastLine);
//            }



//            FileInputStream fs = new FileInputStream(file);
//            int x;
//            char c ='\n';
//            String s ="";
//            while((x = fs.read()) != -1) {
//                if ((char)x != c){
//                    s += (char)x;//записали байт
//                }else if((char)x == c){
//                    arrlist.add(s);//записали строку
//                    s ="";
//                }
//            }
//            for (int i = 1; i <= 10; i++) {
//                System.out.println(arrlist.get(arrlist.size() - i));// в чате в этот момент эти строки
//                //нужно передать в в экран выведеных сообщений с ником отправителя.
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        showLog();

//        File file = new File("log.txt");
//        try {
//            RandomAccessFile raf = new RandomAccessFile(file, "rw");
//            //raf.seek(raf.length());
//            String s = "";
//            char c =(char) raf.read();
//            while (c != -1){
//                if(c != '\n'){
//                    s += c;
//                }else if(c == '\n'){
//                    System.out.println(s);
//                    s = "";
//                }
//
//            }
//
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}