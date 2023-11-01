package tests.webmasters;

import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Selenide;
import database.DataBaseConnector;
import io.qameta.allure.junit4.Tag;
import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.Navigate;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;
import tests.BaseTest;

import java.sql.SQLException;

public class CreateWeb extends BaseTest {
    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private WebmasterCreationPage webmasterCreationPage;

    public CreateWeb(){
        navigate = new Navigate();
        webmastersPage = new WebmastersPage();
        webmasterCreationPage = new WebmasterCreationPage();
    }
    @Test
    public void createActiveWebMin() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMin();
    }

    @Test
    public void createActiveWebMax(){
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMax();
    }




   /* @Test
    public void createActiveWeb() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createActiveWeb();
        sleep(3000);
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }*/



    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
