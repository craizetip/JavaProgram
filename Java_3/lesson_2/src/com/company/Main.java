package com.company;


import java.sql.SQLException;

public class Main {


    public static void start(){

        MeSqlServer.connect();
    }
    public static void stop(){

        MeSqlServer.disconnect();
    }
    public static void reg(String name, String pass, String nick){
        try {
            MeSqlServer.registr(name, pass, nick);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void newName(String name, String newName){
        try {
            MeSqlServer.reName(name, newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       start();
       //reg("Artem", "123456789", "Random");
        newName("Artem", "Andrei");
        MeSqlServer.disconnect();
    }
}
