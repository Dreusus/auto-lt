package tests.databases;

import database.DataBaseConnector;

import java.sql.*;

public class OfferCreateDate {
    public static void printOfferCreatedDates() throws SQLException {
        String query = "SELECT id, name, \"createDate\", \"updateDate\" from offer ORDER BY \"createDate\" DESC LIMIT 1";

        try (Connection connection = DataBaseConnector.getConnection();
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
