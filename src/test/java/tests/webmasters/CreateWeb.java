package tests.webmasters;

import com.codeborne.selenide.Selenide;
import database.DataBaseConnector;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;
import basetest.BaseTest;

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

  /*  @Test
    public void createActiveWebMax(){
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMax();
    } */



    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
