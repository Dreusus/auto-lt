package tests.databases;

import database.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbWebmasterStatus {
    public static void printWebmasterStatusCount() throws SQLException {
        String query = "SELECT status, COUNT(*) as count FROM webmaster WHERE status IN (0, 9, 10) GROUP BY status;";
        int totalWebmaster = 0;
        try (Connection connection = DataBaseConnector.getConnection();
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
}