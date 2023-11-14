package pages.advertiser;

import com.codeborne.selenide.SelenideElement;
import Objects.Offer;


import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
//http://adm.st.leads.tech/offer/create/
public class OfferCreationPage {
    // Константы и генератор случайных данных
    public static final String PATH_IMAGE = "image.png";

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

    private final SelenideElement amountMax = $("#offer-amount_max");
    private final SelenideElement amountMin = $("#offer-amount_min");
    private final SelenideElement minPercentAge = $("#offer-annual_percentage_min");
    private final SelenideElement minPercentDay = $("#offer-daily_percentage_min");
    private final SelenideElement dailyConversionLimit = $("#offer-dailyconversionlimit");
    private final SelenideElement cookieLTV = $("#offer-cookieltv");
    private final SelenideElement minLoanTerm = $("#offer-loantermfrom");
    private final SelenideElement maxLoanTerm = $("#offer-loantermto");



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

    public void selectFirstOption(SelenideElement dropdown, SelenideElement firstOption) {
        dropdown.click();
        firstOption.click();
    }

    public void uploadImage() {
        imageFileButton.uploadFile(new File(PATH_IMAGE));
    }

    public void uploadFavImage() {
        favImageFileButton.uploadFile(new File(PATH_IMAGE));
    }

    public void fillRequiredFieldsOffer(Offer offer) {
        name.setValue(offer.getName());
        slug.setValue(offer.getSlug());
        offerProductName.setValue(offer.getOfferProductName());
        selectFirstOption(advertiserDropdown, advertiserFirst);
        selectFirstOption(currencyDropdown, currencyFirst);
        selectFirstOption(categoryDropdown, categoryFirst);
        selectFirstOption(countryDropdown, countryFirst);
        licence.setValue(offer.getLicense().toString());
        erid.setValue(offer.getErid().toString());
        minAge.setValue(offer.getMinAge().toString());
        maxAge.setValue(offer.getMaxAge().toString());
        hold.setValue(offer.getHold().toString());
        offerLink.setValue(offer.getOfferLink());
        uploadImage();
        uploadFavImage();
        selectFirstOption(trafficBackDropdown, trafficBackFirst);
    }

    public void createOfferActiveMin(Offer offer) {
        fillRequiredFieldsOffer(offer);
        setStatus("Активен");
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='" + offer.getName() + "']").shouldBe(visible);
    }

    public void createOfferActiveMax(Offer offer){
        fillRequiredFieldsOffer(offer);
        setStatus("Активен");
        amountMax.setValue(offer.getAmountMax().toString());
        amountMin.setValue(offer.getAmountMin().toString());
        minPercentAge.setValue(offer.getMinPercentDay().toString());
        minPercentDay.setValue(offer.getMinPercentDay().toString());
        dailyConversionLimit.setValue(offer.getDailyConversionLimit().toString());
        cookieLTV.setValue(offer.getCookieLTV());
        minLoanTerm.setValue(offer.getMinLoanTerm().toString());
        maxLoanTerm.setValue(offer.getMaxLoanTerm().toString());
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='" + offer.getName() + "']").shouldBe(visible);
    }


    public void createOfferPrivate(Offer offer) {
        fillRequiredFieldsOffer(offer);
        setStatus("Приватный");
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='" + offer.getName() + "']").shouldBe(visible);
    }
}



    /*public void createOfferNoActive(Offer offer) {
        fillRequiredFieldsOffer(offer);
        setStatus("Неактивен");
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='" + offer.getName() + "']").shouldBe(visible);
    }

    public void createOfferDelete(Offer offer) {
        fillRequiredFieldsOffer(offer);
        setStatus("Удален");
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='" + offer.getName() + "']").shouldBe(visible);
    }
 */


