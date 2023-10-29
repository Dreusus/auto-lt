package tests;

import com.codeborne.selenide.Selenide;
import database.DataBaseConnector;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;

import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.sleep;

public class WebmastersTests extends BaseTest {

    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private WebmasterCreationPage webmasterCreationPage;

    public WebmastersTests() {
        navigate = new Navigate();
        webmastersPage = new WebmastersPage();
        webmasterCreationPage = new WebmasterCreationPage();
    }

    @Test
    public void createActiveWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createActiveWeb();
        sleep(2000);
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createNoActiveWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createNoActiveWeb();
        sleep(2000);
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createDeleteWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createDeleteWeb();
        sleep(2000);
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
