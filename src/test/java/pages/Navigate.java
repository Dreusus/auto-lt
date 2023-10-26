package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Navigate {

    private static final By WEBMASTERS_NAVIGATION_LINK = By.xpath("//li[@class='dropdown']/a[text()='Вебмастера ']");
    private static final By WEBMASTER_DROPDOWN_LINK = By.xpath("//ul/li/a[text()='Вебмастера']");
    private static final By ADVERTISER_NAVIGATION_LINK = By.xpath("//li[@class='dropdown']/a[text()='Рекламодатели ']");
    private static final By OFFERS_DROPDOWN_LINK = By.xpath("//ul/li/a[text()='Офферы']");

    public void navigateToWebmastersPage() {
        $(WEBMASTERS_NAVIGATION_LINK).click();
        $(WEBMASTER_DROPDOWN_LINK).click();
    }

    public void navigateToOffersPage() {
        $(ADVERTISER_NAVIGATION_LINK).click();
        $(OFFERS_DROPDOWN_LINK).click();
    }
}
