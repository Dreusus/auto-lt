package pages;
import static com.codeborne.selenide.Selenide.$x;

public class Navigate {

    private static final String WEBMASTERS_NAVIGATION_LINK = "//li[@class='dropdown']/a[text()='Вебмастера ']";
    private static final String WEBMASTER_DROPDOWN_LINK = "//ul/li/a[text()='Вебмастера']";
    private static final String ADVERTISER_NAVIGATION_LINK = "//li[@class='dropdown']/a[text()='Рекламодатели ']";
    private static final String OFFERS_DROPDOWN_LINK = "//ul/li/a[text()='Офферы']";

    public void navigateToWebmastersPage() {
        $x(WEBMASTERS_NAVIGATION_LINK).click();
        $x(WEBMASTER_DROPDOWN_LINK).click();
    }

    public void navigateToOffersPage() {
        $x(ADVERTISER_NAVIGATION_LINK).click();
        $x(OFFERS_DROPDOWN_LINK).click();
    }
}
