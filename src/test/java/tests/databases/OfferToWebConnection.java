package tests.databases;

import database.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OfferToWebConnection {
    public static void printOfferWebmasterConnectionStatusCounts()  throws SQLException {
        String query = "SELECT o.id, o.name, owc.status, COUNT(owc.status) " +
                "FROM \"offer\" o " +
                "LEFT JOIN \"offerWebmasterConnection\" owc ON o.id = owc.\"offerId\" " +
                "WHERE o.id = (SELECT id FROM \"offer\" ORDER BY \"createDate\" DESC LIMIT 1) " +
                "GROUP BY o.id, o.name, owc.status";

        try (Connection connection = DataBaseConnector.getConnection();
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
}
