package pages.webmasters;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.*;

public class WebmastersPage {

    private static final By CREATE_WEB_BUTTON = xpath("//a[text()='Регистрация вебмастера']");

    // Создаем экземпляр WebmasterCreationPage один раз, чтобы использовать во всех методах
    private WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();

    public void createWebmasterActive() {
        $(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateActiveWeb();
    }

    public void createWebmasterNoActive() {
        $(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateNoActiveWeb();
    }

    public void createWebmasterDelete() {
        $(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateDeleteWeb();
    }
}
