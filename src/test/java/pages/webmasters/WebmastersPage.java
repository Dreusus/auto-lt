package pages.webmasters;
import static com.codeborne.selenide.Selenide.$x;

public class WebmastersPage {

    private static final String CREATE_WEB_BUTTON = "//a[text()='Регистрация вебмастера']";
    private final WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage();

    public void goToWebmasterRegistration() {
        $x(CREATE_WEB_BUTTON).click();
    }

}