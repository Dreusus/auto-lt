package pages.webmasters;
import static com.codeborne.selenide.Selenide.$x;

public class WebmastersPage {

    private static final String CREATE_WEB_BUTTON = "//a[text()='Регистрация вебмастера']";

    // Создаем экземпляр WebmasterCreationPage один раз, чтобы использовать во всех методах
    private final WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();

    public void createWebmasterActive() {
        $x(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateActiveWeb();
    }

    public void createWebmasterNoActive() {
        $x(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateNoActiveWeb();
    }

    public void createWebmasterDelete() {
        $x(CREATE_WEB_BUTTON).click();
        // Уберем вызов open, так как страница должна открываться автоматически после нажатия на кнопку
        webmasterCreationPage.generateDeleteWeb();
    }
}
