package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Navigate;
import pages.advertiser.OffersPage;
import pages.login.LoginPage;
import pages.webmasters.WebmastersPage;



public class LeadTech {

    private static final String STAND_1 = "http://adm.st.leads.tech";
    private static final String LOGIN_EMAIL = "pitak@dreusus.ru";
    private static final String LOGIN_PASSWORD = "pitak@dreusus.ru";
    private WebDriver driver;
    private LoginPage loginPage;
    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private  OffersPage offersPage;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get(STAND_1);

        loginPage = new LoginPage(driver);

        navigate = new Navigate(driver);

        webmastersPage = new WebmastersPage(driver);

        offersPage = new OffersPage(driver);

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
    public void navigateOffers(){
        navigate.naviagateToOffersPage();
        offersPage.createOfferActive();
    }


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
