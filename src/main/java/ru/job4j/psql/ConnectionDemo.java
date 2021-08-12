package ru.job4j.psql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import ru.job4j.io.Config;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Config cfg = new Config("src/main/resources/psql.properties");
        cfg.load();

        try (Connection connection =
                     DriverManager.getConnection(
                             cfg.value("url"),
                             cfg.value("login"),
                             cfg.value("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (SQLException e) {
            System.out.println("xyuHaHe");
        }
    }

}
