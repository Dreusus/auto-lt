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



    @Description("созданиыва")
    public void createOfferPrivate() {
        Allure.step("arwe");
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferPrivate(offer);
    }


    public void createOfferNoActive() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferNoActive(offer);
    }


    public void createOfferDelete() {

        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferDelete(offer);
    }


   /* public void editCreatedOffer() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(3000);
        offerCreationPage.editOffer("Active_Rename","reslug","222222","222222","0","20","1");
        sleep(3000);
    } */

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }

}
