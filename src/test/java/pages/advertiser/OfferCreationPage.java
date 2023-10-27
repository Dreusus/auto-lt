package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class OfferCreationPage {
    // Константы и генератор случайных данных
    public static final String PATH_IMAGE = "image.png";
    private final Faker faker = new Faker();

    // Элементы управления и поля
    private final SelenideElement buttonSave = $x("//button[@type='submit' and text()='Сохранить']");
    private final SelenideElement imageFileButton = $("#offer-imagefile");
    private final SelenideElement favImageFileButton = $("#offer-favimagefile");

    // Элементы ввода данных
    private final SelenideElement name = $("#offer-name");
    private final SelenideElement slug = $("#offer-slug");
    private final SelenideElement licence = $("#offer-licensenumber");
    private final SelenideElement erid = $("#offer-erid");
    private final SelenideElement hold = $("#offer-holdseconds");
    private final SelenideElement minAge = $("#offer-age_min");
    private final SelenideElement maxAge = $("#offer-age_max");
    private final SelenideElement offerLink = $("#offer-link");
    private final SelenideElement offerProductName = $("#offer-productname");

    // Выпадающие списки и их элементы
    private final SelenideElement statusDropdown = $x("//span[text()='Выберите статус...']");
    private final SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private final SelenideElement privateStatus = $x("//ul/li[text()='Приватный']");
    private final SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private final SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private final SelenideElement advertiserDropdown = $x("//span[@id='select2-offer-advertiserid-container']");
    private final SelenideElement advertiserTest = $x("//ul/li[text()='181 TestAdvertis']");
    private final SelenideElement advertiserFirst = $x("//ul[@id='select2-offer-advertiserid-results']/li[1]");
    private final SelenideElement currencyDropdown = $x("//span[@id='select2-offer-currency-container']");
    private final SelenideElement currencyFirst = $x("//ul[@id='select2-offer-currency-results']/li[1]");
    private final SelenideElement categoryDropdown = $x("//span[@id='select2-offer-categoryid-container']");
    private final SelenideElement categoryFirst = $x("//ul[@id='select2-offer-categoryid-results']/li[1]");
    private final SelenideElement countryDropdown = $x("//span[@id='select2-offer-country-container']");
    private final SelenideElement countryFirst = $x("//ul[@id='select2-offer-country-results']/li[1]");
    private final SelenideElement trafficBackDropdown = $x("//span[@id='select2-offer-trafficbackid-container']");
    private final SelenideElement trafficBackFirst = $x("//ul[@id='select2-offer-trafficbackid-results']/li[1]");

    // Методы для работы с полями
    public void sendName(String prefix) {
        String randomName = prefix + "_" + faker.name().firstName().toLowerCase();
        name.setValue(randomName);
    }

    public void sendSlug() {
        String randomSlug = faker.animal().name();
        slug.setValue(randomSlug);
    }

    public void sendOfferProductName() {
        String randomOfferProductName = faker.job().field();
        offerProductName.setValue(randomOfferProductName);
    }

    public void sendFixedData() {
        licence.setValue("111111");
        erid.setValue("111111");
        minAge.setValue("18");
        maxAge.setValue("100");
        hold.setValue("0");
        offerLink.setValue("https://google.by/?clickId={clickId}&wmid={webmasterid}");
    }

    public void setStatus(String statusName) {
        statusDropdown.click();
        switch (statusName) {
            case "Активен":
                activeStatus.click();
                break;
            case "Приватный":
                privateStatus.click();
                break;
            case "Неактивен":
                noActiveStatus.click();
                break;
            case "Удален":
                deleteStatus.click();
                break;
        }
    }

    // Методы для работы с выпадающими списками
    public void selectFirstOption(SelenideElement dropdown, SelenideElement firstOption) {
        dropdown.click();
        firstOption.click();
    }

    // Методы для загрузки изображений
    public void uploadImage() {
        imageFileButton.uploadFile(new File(PATH_IMAGE));
    }

    public void uploadFavImage() {
        favImageFileButton.uploadFile(new File(PATH_IMAGE));
    }

    // Общий метод создания предложения
    public void generateOffer() {
        sendName("Active");
        setStatus("Активен");
        sendSlug();
        sendOfferProductName();
        selectFirstOption(advertiserDropdown, advertiserFirst);
        selectFirstOption(currencyDropdown, currencyFirst);
        selectFirstOption(categoryDropdown, categoryFirst);
        selectFirstOption(countryDropdown, countryFirst);
        sendFixedData();
        uploadImage();
        uploadFavImage();
        selectFirstOption(trafficBackDropdown, trafficBackFirst);
        buttonSave.click();
        sleep(1000);
    }
}
