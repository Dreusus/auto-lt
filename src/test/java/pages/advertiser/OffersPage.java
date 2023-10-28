package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class OffersPage {

    private SelenideElement createOfferButton = $x("//a[text()='Добавить оффер']");

    public void createOfferActive() {
        createOfferButton.click();
        OfferCreationPage offerCreationPage = new OfferCreationPage();
        offerCreationPage.createOfferActive();
    }

    public void createOfferPrivate() {
        createOfferButton.click();
        OfferCreationPage offerCreationPage = new OfferCreationPage();
        offerCreationPage.createOfferPrivate();
    }

    public void createOfferDelete() {
        createOfferButton.click();
        OfferCreationPage offerCreationPage = new OfferCreationPage();
        offerCreationPage.createOfferDelete();
    }

    public void createOfferNoActive() {
        createOfferButton.click();
        OfferCreationPage offerCreationPage = new OfferCreationPage();
        offerCreationPage.createOfferNoActive();
    }

}
