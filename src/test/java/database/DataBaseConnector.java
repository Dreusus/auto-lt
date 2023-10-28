package database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class DataBaseConnector {

    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    static {
        try {

            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream(new File("src/test/java/config/database.properties"));
            properties.load(inputStream);

            dbUrl = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");

            // Загрузка JDBC драйвера
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database connection parameters");
        }
    }
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public static List<String> getTables() {
        List<String> tables = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT tablename FROM pg_tables WHERE schemaname = 'public';")) {

            while (resultSet.next()) {
                tables.add(resultSet.getString("tablename"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tables;
    }

    public static void main(String[] args) {
        List<String> tables = getTables();
        for (String table : tables) {
            System.out.println(table);
        }
    }

}
