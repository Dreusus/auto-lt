package pages.advertiser;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//http://adm.st.leads.tech/offer/update/?id=
//Редактирование полей оффера
public class OfferUpdatePage {
    private String offerId;
    private SelenideElement rate;

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
    public OfferUpdatePage(String offerId) {
        this.offerId = offerId;
        this.rate = $x("//a[contains(@href, '/rate/offer/?offerId=" + offerId + "')]");
    }

    public OfferUpdatePage() {

    }

    public void editFieldsOffer() {
        name.setValue("editName");
        slug.setValue("editslug");
        offerProductName.setValue("edit");
        licence.setValue("edit");
        erid.setValue("edit");
        minAge.setValue("1");
        maxAge.setValue("100");
        hold.setValue("1");
        amountMax.setValue("100");
        amountMin.setValue("100");
        dailyConversionLimit.setValue("100");
        cookieLTV.setValue("100");
        minLoanTerm.setValue("100");
        maxLoanTerm.setValue("100");
        minPercentAge.setValue("100");
        minPercentDay.setValue("0");
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='editName']").shouldBe(visible);
    }
    public void navigateToOfferRatePage() {
        rate.click();
    }
}
