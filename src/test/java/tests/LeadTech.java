package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import database.DataBaseConnector;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OffersPage;
import pages.login.LoginPage;
import pages.webmasters.WebmastersPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;

public class LeadTech {

    private static final String STAND_1 = "http://adm.st.leads.tech";
    private static final String LOGIN_EMAIL = "pitak@dreusus.ru";
    private static final String LOGIN_PASSWORD = "pitak@dreusus.ru";

    private LoginPage loginPage;
    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private OffersPage offersPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";

        open(STAND_1);

        loginPage = new LoginPage();
        navigate = new Navigate();
        webmastersPage = new WebmastersPage();
        offersPage = new OffersPage();

        loginPage.login(LOGIN_EMAIL, LOGIN_PASSWORD);
    }




    @Test
    public void createActiveWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.createWebmasterActive();
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createNoActiveWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.createWebmasterNoActive();
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createDeleteWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.createWebmasterDelete();
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createOfferActive(){
        navigate.navigateToOffersPage();
        offersPage.createOfferActive();
        try {
            DataBaseConnector.printWebmasterStatusCount();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createOfferPrivate(){
        navigate.navigateToOffersPage();
        offersPage.createOfferPrivate();
        try {
            DataBaseConnector.printOfferStatusCounts();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }


    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
