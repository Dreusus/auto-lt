package pages.advertiser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class OffersPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Добавить оффер']")
    private WebElement createOfferButton;

    public OffersPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void createOfferActive() {
        createOfferButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://adm.st.leads.tech/offer/create/", currentUrl);

        OfferCreationPage offerCreationPage = new OfferCreationPage(driver);
        offerCreationPage.generateOffer();
    }



}
