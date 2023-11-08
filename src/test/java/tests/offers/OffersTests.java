package tests.offers;

import static com.codeborne.selenide.Selenide.sleep;

import Objects.Offer;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;

import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OffersPage;
import basetest.BaseTest;


public class OffersTests extends BaseTest {

    private Navigate navigate;
    private OffersPage offersPage;
    private OfferCreationPage offerCreationPage;

    public OffersTests() {
        navigate = new Navigate();
        offersPage = new OffersPage();
        offerCreationPage = new OfferCreationPage();
    }

    @Test
    public void createOfferActive() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive(offer);
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

    /*
    @Test
    public void createOfferNoActive() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferNoActive(offer);
    }

    @Test
    public void createOfferDelete() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferDelete(offer);
    }
    */


    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }

}
