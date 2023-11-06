package tests.databases;

import com.codeborne.selenide.logevents.SelenideLogger;
import database.DataBaseConnector;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

public class dbTests {


    @Test
    @Description("Вывод всех статусов оффера")
   public void printOfferStatus() throws SQLException {
        Allure.step("Запрос в БД");
        dbOfferStatus.printOfferStatusCounts();
    }

    @Test
    public void printWebStatus() throws SQLException {
        dbWebmasterStatus.printWebmasterStatusCount();
    }

}
