package ru.job4j.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private static Properties properties;

    private Connection connection;

    public TableEditor(Properties properties) {
        TableEditor.properties = properties;
        initConnection();
    }

    private void initConnection() {
        connection = null;
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws Exception {
                String sql = String.format("CREATE TABLE if not exists %s ();",
                        tableName
                );
                statementConnection(sql);
    }

    public void dropTable(String tableName) throws Exception {
                String sql = String.format("DROP TABLE if exists %s;",
                        tableName
                );
                statementConnection(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
                String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s;",
                        tableName,
                        columnName,
                        type
                );
                statementConnection(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
                String sql = String.format("ALTER TABLE %s DROP COLUMN %s;",
                        tableName,
                        columnName
                );
                statementConnection(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName)
            throws Exception {
                String sql = String.format(
                        "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                        tableName,
                        columnName,
                        newColumnName
                );
                statementConnection(sql);
    }

    private void statementConnection(String sql) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("src/main/resources/psql.properties");
        Properties pps = new Properties();
        pps.load(reader);
        TableEditor te = new TableEditor(pps);

        te.createTable("test");
        te.addColumn("test", "amount", "int");
        te.renameColumn("test", "amount", "price");
        System.out.println(getTableScheme(getConnection(), "test"));
        te.dropColumn("test", "price");
        te.dropTable("test");
    }
}