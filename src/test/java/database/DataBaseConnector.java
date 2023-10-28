package database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DataBaseConnector {

    private static final String dbUrl;
    private static final String dbUser;
    private static final String dbPassword;

    static {
        //Загрузка констант из database.properties
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(new File("src/test/java/config/database.properties"))) {
            properties.load(inputStream);

            dbUrl = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");

            // Загрузка JDBC драйвера
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database connection parameters", e);
        }
    }

    //Установление соединения с БД
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public static void printLastCreatedWebmaster() throws SQLException {
        String query = "SELECT * FROM webmaster ORDER BY \"createDate\" DESC LIMIT 1";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Получаем метаданные о ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    // Выводим имя столбца и значение
                    System.out.println(columnName + ": " + columnValue);
                }
            } else {
                System.out.println("Вебмастер не найден.");
            }

        }
    }



    public static void main(String[] args) {
        try {
            printLastCreatedWebmaster();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }
}
