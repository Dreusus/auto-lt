package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
//http://adm.st.leads.tech/offer/index/
public class OffersPage {

    private SelenideElement createOfferButton = $x("//a[text()='Добавить оффер']");
    private final OfferCreationPage offerCreationPage = new OfferCreationPage();

    public void goToOfferRegistration() {
        createOfferButton.click();
    }
}


