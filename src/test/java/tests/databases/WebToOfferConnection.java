package tests.databases;

import database.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebToOfferConnection {
    public static void printWebmasterOfferConnectionStatusCounts() throws SQLException {
        String query = "SELECT w.id, w.\"firstName\", w.\"lastName\", owc.status, COUNT(owc.status) " +
                "FROM \"webmaster\" w " +
                "LEFT JOIN \"offerWebmasterConnection\" owc ON w.id = owc.\"webmasterId\" " +
                "WHERE w.id = (SELECT id FROM \"webmaster\" ORDER BY \"createDate\" DESC LIMIT 1) " +
                "GROUP BY w.id, w.\"firstName\", w.\"lastName\", owc.status";

        try (Connection connection = DataBaseConnector.getConnection();
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
}
