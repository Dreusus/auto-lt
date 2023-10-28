package pages.webmasters;
import static com.codeborne.selenide.Selenide.$x;

public class WebmastersPage {

    private static final String CREATE_WEB_BUTTON = "//a[text()='Регистрация вебмастера']";
    private final WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();
    public void createWebmasterActive() {
        $x(CREATE_WEB_BUTTON).click();
        webmasterCreationPage.generateActiveWeb();
    }

    public void createWebmasterNoActive() {
        $x(CREATE_WEB_BUTTON).click();
        webmasterCreationPage.generateNoActiveWeb();
    }

    public void createWebmasterDelete() {
        $x(CREATE_WEB_BUTTON).click();
        webmasterCreationPage.generateDeleteWeb();
    }
}
