package tests.webmasters;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;
import basetest.BaseTest;
import Objects.Webmaster;

public class CreateWebTests extends BaseTest {
    private Navigate navigate;
    private WebmastersPage webmastersPage;
    private WebmasterCreationPage webmasterCreationPage;

    public CreateWebTests(){
        navigate = new Navigate();
        webmastersPage = new WebmastersPage();
        webmasterCreationPage = new WebmasterCreationPage();
    }

 @Test
 @Description("Создание вебмастера со всеми обязательными параметрами")
    public void createActiveWebMin() {
        Webmaster webmaster = new Webmaster();
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMin(webmaster);
    }

    @Test
    @Description("Создание веба со всеми возможными параметрами")
    public void createActiveWebMax(){
        Webmaster webmaster = new Webmaster();
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMax(webmaster);
    }



    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
