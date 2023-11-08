package tests.offers;

import static com.codeborne.selenide.Selenide.sleep;

import Objects.Offer;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;

import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OfferUpdatePage;
import pages.advertiser.OffersPage;
import basetest.BaseTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        System.out.println("Полный URL: " + currentUrl);
        String offerId = extractOfferId(currentUrl);
        System.out.println(offerId);

        OfferUpdatePage offerUpdatePage = new OfferUpdatePage(offerId);
        offerUpdatePage.navigateToRate();

    }

    private String extractOfferId(String url) {
        Pattern pattern = Pattern.compile("id=(\\d+)");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
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
