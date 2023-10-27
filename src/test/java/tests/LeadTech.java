package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OffersPage;
import pages.login.LoginPage;
import pages.webmasters.WebmastersPage;

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
    }

    @Test
    public void createNoActiveWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.createWebmasterNoActive();
    }

    @Test
    public void createDeleteWM() {
        navigate.navigateToWebmastersPage();
        webmastersPage.createWebmasterDelete();
    }

    @Test
    public void createOffers(){
        navigate.navigateToOffersPage();
        offersPage.createOfferActive();
    }


    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
