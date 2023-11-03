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

        /*     dbUrl = properties.getProperty("db2.url");
            dbUser = properties.getProperty("db2.user");
            dbPassword = properties.getProperty("db2.password"); */

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

    public static void printOfferStatusCounts() throws SQLException {
        String query = "SELECT status, COUNT(*) as count FROM offer WHERE status IN (0, 9, 10, 11) GROUP BY status;";
        int totalOffers = 0;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int status = resultSet.getInt("status");
                int count = resultSet.getInt("count");
                totalOffers += count;

                switch (status) {
                    case 10:
                        System.out.println("Офферов в статусе Активный: " + count);
                        break;
                    case 11:
                        System.out.println("Офферов в статусе Приватный: " + count);
                        break;
                    case 9:
                        System.out.println("Офферов в статусе Неактивый: " + count);
                        break;
                    case 0:
                        System.out.println("Офферов в статусе Удален: " + count);
                        break;
                }
            }
           // System.out.println("Всего офферов: " + totalOffers);
        }
    }

    public static void printWebmasterStatusCount() throws  SQLException {
        String query = "SELECT status, COUNT(*) as count FROM webmaster WHERE status IN (0, 9, 10) GROUP BY status;";
        int totalWebmaster = 0;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int status = resultSet.getInt("status");
                int count = resultSet.getInt("count");
                totalWebmaster += count;

                switch (status) {
                    case 10:
                        System.out.println("Вебмастеров в статусе Активный: " + count);
                        break;
                    case 9:
                        System.out.println("Вебмастеров в статусе Неактивый: " + count);
                        break;
                    case 0:
                        System.out.println("Вебмастеров в статусе Удален: " + count);
                        break;
                }
            }
            System.out.println("Всего вебмастеров: " + totalWebmaster);
        }

    }
    public static void printWebmasterOfferConnectionStatusCounts() throws SQLException {
        String query = "SELECT w.id, w.\"firstName\", w.\"lastName\", owc.status, COUNT(owc.status) " +
                "FROM \"webmaster\" w " +
                "LEFT JOIN \"offerWebmasterConnection\" owc ON w.id = owc.\"webmasterId\" " +
                "WHERE w.id = (SELECT id FROM \"webmaster\" ORDER BY \"createDate\" DESC LIMIT 1) " +
                "GROUP BY w.id, w.\"firstName\", w.\"lastName\", owc.status";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int webmasterId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int status = resultSet.getInt("status");
                int count = resultSet.getInt("count");

                System.out.println("Webmaster ID: " + webmasterId + ", Имя: " + firstName + ", Фамилия: " + lastName + ", Статус: " + status + ", Количество: " + count);
            }
        }
    }

    public static void printOfferWebmasterConnectionStatusCounts()  throws SQLException{
        String query = "SELECT o.id, o.name, owc.status, COUNT(owc.status) " +
                "FROM \"offer\" o " +
                "LEFT JOIN \"offerWebmasterConnection\" owc ON o.id = owc.\"offerId\" " +
                "WHERE o.id = (SELECT id FROM \"offer\" ORDER BY \"createDate\" DESC LIMIT 1) " +
                "GROUP BY o.id, o.name, owc.status";

        try (Connection connection = getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int offerId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int status = resultSet.getInt("status");
                int count = resultSet.getInt("count");

                System.out.println("OfferID: " + offerId + ", Имя " + name + ",Статус: " + status + ", Количество: " + count);
            }
        }
    }


    public static void printOfferCreatedDates() throws SQLException {
        String query = "SELECT id, name, \"createDate\", \"updateDate\" from offer ORDER BY \"createDate\" DESC LIMIT 1";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int offerId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp createDate = resultSet.getTimestamp("createDate");
                Timestamp updateDate = resultSet.getTimestamp("updateDate");
                System.out.println("OfferID: " + offerId + ", Имя " + name + ",Дата создания: " + createDate + ", Дата обновления: " + updateDate);
            }
        }
    }


}

