package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class OffersPage {

    private SelenideElement createOfferButton = $x("//a[text()='Добавить оффер']");

    public void createOfferActive() {
        createOfferButton.click();
       // String currentUrl = url();
        //assertEquals("http://adm.st.leads.tech/offer/create/", currentUrl);

        OfferCreationPage offerCreationPage = new OfferCreationPage();
        offerCreationPage.generateOffer();
    }
}
