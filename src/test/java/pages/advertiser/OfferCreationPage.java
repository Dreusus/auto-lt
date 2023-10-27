package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class OfferCreationPage {
    public static final String pathImage = "image.png";
    private Faker faker = new Faker();
    private SelenideElement buttonSave = $x("//button[@type='submit' and text()='Сохранить']");
    private SelenideElement imageFileButton = $("#offer-imagefile");
    private SelenideElement favImageFileButton = $("#offer-favimagefile");
    private SelenideElement name = $("#offer-name");
    private SelenideElement slug = $("#offer-slug");
    private SelenideElement licence = $("#offer-licensenumber");
    private SelenideElement erid = $("#offer-erid");
    private SelenideElement hold = $("#offer-holdseconds");
    private SelenideElement minAge = $("#offer-age_min");
    private SelenideElement maxAge = $("#offer-age_max");
    private SelenideElement offerLink = $("#offer-link");
    private SelenideElement statusDropdown = $x("//span[text()='Выберите статус...']");
    private SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private SelenideElement privateStatus = $x("//ul/li[text()='Приватный']");
    private SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private SelenideElement offerProductName = $("#offer-productname");
    private SelenideElement advertiserDropdown = $x("//span[@id='select2-offer-advertiserid-container']");
    private SelenideElement advertiserTest = $x("//ul/li[text()='181 TestAdvertis']");
    private SelenideElement advertiserFirst = $x("//ul[@id='select2-offer-advertiserid-results']/li[1]");

    private  SelenideElement currencyDropdown = $x("//span[@id='select2-offer-currency-container']");
    private  SelenideElement currencyFirst = $x("//ul[@id='select2-offer-currency-results']/li[1]");

    private SelenideElement categoryDropdown = $x("//span[@id='select2-offer-categoryid-container']");
    private SelenideElement categoryFirst = $x("//ul[@id='select2-offer-categoryid-results']/li[1]");

    private SelenideElement countryDropdown = $x("//span[@id='select2-offer-country-container']");
    private SelenideElement countryFirst = $x("//ul[@id='select2-offer-country-results']/li[1]");

    private SelenideElement trafficBackDropdown = $x("//span[@id='select2-offer-trafficbackid-container']");
    private SelenideElement trafficBackFirst = $x("//ul[@id='select2-offer-trafficbackid-results']/li[1]");
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

    public void setCurrencyFirst() {
        currencyDropdown.click();
        currencyFirst.click();
    }

    public void setCategoryFirst() {
       categoryDropdown.click();
       categoryFirst.click();
    }

    public void setCountryFirst() {
        countryDropdown.click();
        countryFirst.click();
    }

    public void sendlicence() {
        licence.setValue("111111");
    }
    public void sendErid() {
        erid.setValue("111111");
    }
    public void sendMinAge() {
        minAge.setValue("18");
    }

    public void sendMaxAge() {
        maxAge.setValue("100");
    }

    public void sendHold() {
        hold.setValue("0");
    }

    public void sendLink() {
        offerLink.setValue("https://google.by/?clickId={clickId}&wmid={webmasterid}");
    }

    public void setTrafficBackFirst() {
        trafficBackDropdown.click();
        trafficBackFirst.click();
    }
    public void uploadImage() {
        imageFileButton.uploadFile(new File(pathImage));
    }

    public void uploadFavImage() {
        favImageFileButton.uploadFile(new File(pathImage));
    }

    public void buttonSaveClick() {
        buttonSave.click();
        sleep(1000);// костыль пока
    }
    public void generateOffer() {
        sendNameActive();
        setStatusActive();
        sendSlug();
        sendOfferProductName();
        setAdvertiserFirst();
        setCurrencyFirst();
        setCategoryFirst();
        setCountryFirst();
        sendlicence();
        sendErid();
        sendMinAge();
        sendMaxAge();
        sendLink();
        sendHold();
        uploadImage();
        uploadFavImage();
        setTrafficBackFirst();
        buttonSaveClick();
    }
}
