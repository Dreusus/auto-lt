package tests.webmasters;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;
import basetest.BaseTest;

public class CreateWeb extends BaseTest {
    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private WebmasterCreationPage webmasterCreationPage;

    public CreateWeb(){
        navigate = new Navigate();
        webmastersPage = new WebmastersPage();
        webmasterCreationPage = new WebmasterCreationPage();
    }


    public void createActiveWebMin() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMin();
    }

    @Test
    @Description("Создание веба с обязательными параметрами")
    public void createActiveWebMax(){
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMax();
    }



    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
