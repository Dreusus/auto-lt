package tests.offers;

import static com.codeborne.selenide.Selenide.sleep;

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


    public void createOfferActive() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(3000);
    }



    @Description("созданиыва")
    public void createOfferPrivate() {
        Allure.step("arwe");
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferPrivate();
    }


    public void createOfferNoActive() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferNoActive();
    }


    public void createOfferDelete() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferDelete();
    }


    public void editCreatedOffer() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(3000);
        offerCreationPage.editOffer("Active_Rename","reslug","222222","222222","0","20","1");
        sleep(3000);
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }

}
