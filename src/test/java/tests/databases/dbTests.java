package tests.databases;

import com.codeborne.selenide.logevents.SelenideLogger;
import database.DataBaseConnector;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

public class dbTests {


    @Test
   public void printOfferStatus() throws SQLException {

        dbOfferStatus.printOfferStatusCounts();
    }

    @Test
    public void printWebStatus() throws SQLException {
        dbWebmasterStatus.printWebmasterStatusCount();
    }

}
