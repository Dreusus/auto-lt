package pages.advertiser;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferCreationPage {

    private WebDriver driver;
    private Faker faker;

    @FindBy(id="offer-name")
    private WebElement name;

    @FindBy(id="offer-slug")
    private WebElement slug;

    @FindBy(xpath="//span[text()='Выберите статус...']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//ul/li[text()='Активен']")
    private WebElement activeStatus;

    @FindBy(xpath = "//ul/li[text()='Приватный']")
    private WebElement privateStatus;
    @FindBy(xpath = "//ul/li[text()='Неактивен']")
    private WebElement noActiveStatus;
    @FindBy(xpath = "//ul/li[text()='Удален']")
    private WebElement deleteStatus;

    @FindBy(id="offer-productname")
    private WebElement offerProductName;
    @FindBy(xpath = "//span[text()='Выберите рекламодателя...']")
    private WebElement advertiserDropdown;

    @FindBy(xpath = "//ul/li[text()='181 TestAdvertis']")
    private WebElement advertiserTest;

    @FindBy(xpath = "//ul[@id='select2-offer-advertiserid-results']/li[1]")
    private WebElement advertiserFirst;

    public  OfferCreationPage(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        PageFactory.initElements(driver,this);
    }

    public void sendNameActive() {
        String randomName = "Active_" + faker.name().firstName().toLowerCase();
        name.sendKeys(randomName);
    }
    public void sendNamePrivate() {
        String randomName = "Private_" + faker.name().firstName().toLowerCase();
        name.sendKeys(randomName);
    }

    public void sendNameNoActive() {
        String randomName = "NoActive_" + faker.name().firstName().toLowerCase();
        name.sendKeys(randomName);
    }
    public void sendNameDelete() {
        String randomName = "Delete_" + faker.name().firstName().toLowerCase();
        name.sendKeys(randomName);
    }

    public void setStatusActive() {
        statusDropdown.click();
        activeStatus.click();
    }
    public void setStatusPrivate() {
        statusDropdown.click();
        privateStatus.click();
    }
    public void setStatusNoActive()   {
        statusDropdown.click();
        noActiveStatus.click();
    }

    public void setStatusDelete() {
        statusDropdown.click();
        deleteStatus.click();
    }

    public void sendSlug() {
        String randomSlug = faker.animal().name();
        slug.sendKeys(randomSlug);
    }

    public void sendOfferProductName() {
        String randomOfferProductName = faker.job().field();
        offerProductName.sendKeys(randomOfferProductName);

    }


    public void setAdvertiserTest() {
        advertiserDropdown.click();
        advertiserTest.click();
    }

    public void setAdvertiserFirst() {
        advertiserDropdown.click();
        advertiserFirst.click();
    }

    public void generateOffer() {
        sendNameActive();
        setStatusActive();
        sendSlug();
        sendOfferProductName();
        setAdvertiserTest();

    }

}
