package tests.databases;

import database.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbOfferStatus {
    public static void printOfferStatusCounts() throws SQLException {
        String query = "SELECT status, COUNT(*) as count FROM offer WHERE status IN (0, 9, 10, 11) GROUP BY status;";
        int totalOffers = 0;

        try (Connection connection = DataBaseConnector.getConnection();
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
            System.out.println("Всего офферов: " + totalOffers);
        }
    }

}
