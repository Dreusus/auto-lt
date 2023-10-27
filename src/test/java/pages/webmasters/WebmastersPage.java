package pages.webmasters;

import static com.codeborne.selenide.Selenide.$;

public class WebmastersPage {

    private static final String CREATE_WEB_BUTTON = "//a[text()='Регистрация вебмастера']";

    // Создаем экземпляр WebmasterCreationPage один раз, чтобы использовать во всех методах
    private final WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();

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
