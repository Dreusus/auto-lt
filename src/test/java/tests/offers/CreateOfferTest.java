package tests.offers;

import Objects.Offer;
import basetest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OffersPage;

import static com.codeborne.selenide.Selenide.sleep;

public class CreateOfferTest extends BaseTest {
    private Navigate navigate;
    private OffersPage offersPage;
    private OfferCreationPage offerCreationPage;

    public CreateOfferTest() {
        navigate = new Navigate();
        offersPage = new OffersPage();
        offerCreationPage = new OfferCreationPage();
    }

    @Test
    public void createOfferActiveMin() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActiveMin(offer);
        sleep(3000);
    }

    @Test
    public void createOfferActiveMax() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActiveMax(offer);
        sleep(3000);
    }

    @Test
    public void createOfferPrivate() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferPrivate(offer);
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }


}
