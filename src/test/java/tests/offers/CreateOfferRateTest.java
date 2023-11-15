package tests.offers;

import Objects.Offer;
import basetest.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OfferRatePage;
import pages.advertiser.OfferUpdatePage;
import pages.advertiser.OffersPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;


public class CreateOfferRateTest extends BaseTest {

    private Navigate navigate;
    private OffersPage offersPage;
    private OfferCreationPage offerCreationPage;
    private OfferRatePage offerRatePage;
    public CreateOfferRateTest() {
        navigate = new Navigate();
        offersPage = new OffersPage();
        offerCreationPage = new OfferCreationPage();
        offerRatePage = new OfferRatePage();
    }
    public void navigateToOfferRate() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String offerId = extractOfferId(currentUrl);

        OfferUpdatePage offerUpdatePage = new OfferUpdatePage(offerId);
        offerUpdatePage.navigateToOfferRatePage();
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
    public void createOfferRate() {
        Offer offer = new Offer();
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActiveMax(offer);
        navigateToOfferRate();
        offerRatePage.createRate();
    }
    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }

}
