package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;

public class OfferCreationPage {

    private Faker faker = new Faker();

    private SelenideElement name = $("#offer-name");
    private SelenideElement slug = $("#offer-slug");
    private SelenideElement statusDropdown = $x("//span[text()='Выберите статус...']");
    private SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private SelenideElement privateStatus = $x("//ul/li[text()='Приватный']");
    private SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private SelenideElement offerProductName = $("#offer-productname");
    private SelenideElement advertiserDropdown = $x("//span[text()='Выберите рекламодателя...']");
    private SelenideElement advertiserTest = $x("//ul/li[text()='181 TestAdvertis']");
    private SelenideElement advertiserFirst = $x("//ul[@id='select2-offer-advertiserid-results']/li[1]");

    public void sendNameActive() {
        String randomName = "Active_" + faker.name().firstName().toLowerCase();
        name.setValue(randomName);
    }

    public void sendNamePrivate() {
        String randomName = "Private_" + faker.name().firstName().toLowerCase();
        name.setValue(randomName);
    }

    public void sendNameNoActive() {
        String randomName = "NoActive_" + faker.name().firstName().toLowerCase();
        name.setValue(randomName);
    }

    public void sendNameDelete() {
        String randomName = "Delete_" + faker.name().firstName().toLowerCase();
        name.setValue(randomName);
    }

    public void setStatusActive() {
        statusDropdown.click();
        activeStatus.click();
    }

    public void setStatusPrivate() {
        statusDropdown.click();
        privateStatus.click();
    }

    public void setStatusNoActive() {
        statusDropdown.click();
        noActiveStatus.click();
    }

    public void setStatusDelete() {
        statusDropdown.click();
        deleteStatus.click();
    }

    public void sendSlug() {
        String randomSlug = faker.animal().name();
        slug.setValue(randomSlug);
    }

    public void sendOfferProductName() {
        String randomOfferProductName = faker.job().field();
        offerProductName.setValue(randomOfferProductName);
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
