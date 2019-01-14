package com.company;


import java.sql.*;

public abstract class MeSqlServer {
    public static Connection connection;//для подключения к БД
    private static Statement statement;// для запросов БД

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");//региструем драйвер БД
            connection = DriverManager.getConnection("jdbc:sqlite:BDchat.db");//по пратаколу JBDC, для базы данных sqlite, название, БД
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    synchronized static void disconnect() {//отключаем БД от чата
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    synchronized static void reName(String name, String newName) throws SQLException {//заменяем старое имя на новое
        String request = "UPDATE users SET  login = '" + newName + "' WHERE login = '" + name + "'";
        int set = statement.executeUpdate(request);
    }

    synchronized static void registr (String name, String password, String nick) throws SQLException {// регестрация
        String registras = "INSERT INTO users (login, password, nickname) VALUES ('" + name +
                "', '" + password + "', '" + nick + "');";

        int set = statement.executeUpdate(registras);

    }
}

