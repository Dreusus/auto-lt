package pages.webmasters;
import basetest.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WebmastersPage extends BaseTest {

    private static final String CREATE_WEB_BUTTON = "//a[text()='Регистрация вебмастера']";
    private final WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();
    public SelenideElement createWebButton = $(By.xpath("//a[text()='Регистрация вебмастера']"));

    public void goToWebmasterRegistration() {
        createWebButton.click();
    }

}