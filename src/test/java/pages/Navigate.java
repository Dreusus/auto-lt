package pages;

import static com.codeborne.selenide.Selenide.$;

public class Navigate {

    private static final String WEBMASTERS_NAVIGATION_LINK = "//li[@class='dropdown']/a[text()='Вебмастера ']";
    private static final String WEBMASTER_DROPDOWN_LINK = "//ul/li/a[text()='Вебмастера']";
    private static final String ADVERTISER_NAVIGATION_LINK = "//li[@class='dropdown']/a[text()='Рекламодатели ']";
    private static final String OFFERS_DROPDOWN_LINK = "//ul/li/a[text()='Офферы']";

    public void navigateToWebmastersPage() {
        $(WEBMASTERS_NAVIGATION_LINK).click();
        $(WEBMASTER_DROPDOWN_LINK).click();
    }

    public void navigateToOffersPage() {
        $(ADVERTISER_NAVIGATION_LINK).click();
        $(OFFERS_DROPDOWN_LINK).click();
    }
}
