package tests.offers;


import database.DataBaseConnector;

import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OffersPage;
import basetest.BaseTest;

import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.sleep;

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
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(3000);
    }

   /* @Test
    public void createOfferPrivate() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferPrivate();
    }

   @Test
    public void createOfferNoActive() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferNoActive();
    }

    @Test
    public void createOfferDelete() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferDelete();
    }

    @Test
    public void editCreatedOffer() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(3000);
        offerCreationPage.editOffer("Active_Rename","reslug","222222","222222","0","20","1");
        sleep(3000);

    } */

}
