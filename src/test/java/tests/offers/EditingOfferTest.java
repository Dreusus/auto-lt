package tests.offers;

import Objects.Offer;
import basetest.BaseTest;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OfferUpdatePage;
import pages.advertiser.OffersPage;

public class EditingOfferTest extends BaseTest {
    private Navigate navigate;
    private OffersPage offersPage;
    private OfferCreationPage offerCreationPage;
    private CreateOfferTest createOfferTest;
    private OfferUpdatePage offerUpdatePage;

    public EditingOfferTest() {
        navigate = new Navigate();
        offersPage = new OffersPage();
        offerCreationPage = new OfferCreationPage();
        createOfferTest = new CreateOfferTest();
        offerUpdatePage = new OfferUpdatePage();
    }

    @Test
    public void editingOffer() {
        createOfferTest.createOfferActiveMax();
        offerUpdatePage.editFieldsOffer();

    }

}
