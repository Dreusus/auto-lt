package pages.webmasters;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebmasterCreationPage {

    private static final Faker faker = new Faker();

    //Обязательные поля
    private final SelenideElement email = $("#web-email");
    private final SelenideElement firstName = $("#web-firstname");
    private final SelenideElement lastName = $("#web-lastname");

    private final SelenideElement statusDropdown = $x("//span[@id='select2-web-status-container']");
    private final SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private final SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private final SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private final SelenideElement password = $("#web-password");
    private final SelenideElement passwordConfirm = $("#web-passwordconfirm");

    //Необязательные
    private final SelenideElement phone = $("#web-phone");
    private final SelenideElement middleName = $("#web-middlename");
    private final SelenideElement managerIdDropDown = $x("//span[@id='select2-web-managerid-container']");
    private final SelenideElement managerId1 = $x("//ul[@id='select2-web-managerid-results']/li[5]");
    private final SelenideElement webGroupDropDown = $x("//input[@placeholder='Выберите группы вебмастеров...']");
    private final SelenideElement webGroup1 = $x("//ul[@id='select2-web-groups-results']/li[1]");
    private final SelenideElement legalEntityDropDown = $x("//input[@placeholder='Выберите юридические лица...']");
    private final SelenideElement legalEntity1 = $x("//ul[@id='select2-web-companyids-results']/li[1]");
    private final SelenideElement cpaPercent = $("#web-cpapercent");
    private final SelenideElement refPercent = $("#web-refbackpercent");
    private final SelenideElement telegramChatId = $("#chat-chatid");
    private final SelenideElement webTraffic = $("#web-traffic");
    private final SelenideElement webTimeZone = $("#web-timezone");
    private final SelenideElement webOrgMode = $("#web-orgmode");
    private final SelenideElement webSkill = $("#web-skill");
    private final SelenideElement webPayForm = $("#web-payform");
    private final SelenideElement webOthersContacts = $("#web-othercontacts");
    private final SelenideElement telegramNick = $("#web-telegramnick");

    private final SelenideElement buttonSave = $x("//button[@type='submit' and text()='Сохранить']");


    //Обязательные
    public void enterEmail() {
        String randomEmail = "activeWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.setValue(randomEmail);
    }
    public void selectStatus() {
        statusDropdown.click();
        activeStatus.click();
    }
    public void enterFirstName() {
        String randomFirstName = faker.name().firstName();
        firstName.setValue(randomFirstName);
    }
    public void enterLastName() {
        String randomLastName = faker.name().lastName();
        lastName.setValue(randomLastName);
    }
    public void enterPassword() {
        String randomPassword = faker.internet().password(6, 8, true, true, true);
        password.setValue(randomPassword);
        passwordConfirm.setValue(randomPassword);
    }

    //Необязательные
    public void enterPhone() {
        String randomPhone = "7" + faker.number().digits(10);
        phone.setValue(randomPhone);
    }
    public void enterMiddleName() {
        String randomMiddleName = faker.name().firstName();
        middleName.setValue(randomMiddleName);
    }

    public void selectWebGroup() {
        webGroupDropDown.click();
        webGroup1.click();
    }

    public void selectLegalEntity() {
        legalEntityDropDown.click();
        legalEntity1.click();
    }
    public void enterTelegramNick() {
        String randomTg = faker.name().firstName();
        telegramNick.setValue("@" + randomTg);
    }
    public void setCpaPercent() {
        cpaPercent.setValue("10");
    }

    public void selectManager() {
        managerIdDropDown.click();
        managerId1.click();
    }
    public void setRefPercent() {
        refPercent.setValue("5");
    }
    public void enterChatTelegram() {
        telegramChatId.setValue("666");
    }

    public void enterWebTraffic() {
        String random = faker.color().name();
        webTraffic.setValue(random);
    }
    public void enterWebOrgMode() {
        String random = faker.food().fruit();
        webOrgMode.setValue(random);
    }

    public void enterWebTimeZone() {
        webTimeZone.setValue("мск");
    }

    public void enterWebSkill() {
        webSkill.setValue("1.5");
    }
    public void enterWebPayForm() {
        webPayForm.setValue("Нал");
    }

    public void enterWebOtherContacts() {
       String random = faker.animal().name();
        webOthersContacts.setValue(random);
    }


    public void submitForm() {
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='Редактирование']").shouldBe(visible);
    }
    public void fillRequiredFieldsWebMaster() {
        enterEmail();
        enterFirstName();
        enterLastName();
        enterPassword();
        selectStatus();
    }

    public void  createWebMin() {
        fillRequiredFieldsWebMaster();
        submitForm();
    }

    public void createWebMax() {
        fillRequiredFieldsWebMaster();
        enterPhone();
        enterMiddleName();
        selectManager();
        selectWebGroup();
        selectLegalEntity();
        setRefPercent();
        setCpaPercent();
        enterChatTelegram();
        enterTelegramNick();
        enterWebTraffic();
        enterWebOrgMode();
        enterWebTimeZone();
        enterWebSkill();
        enterWebPayForm();
        enterWebOtherContacts();
        submitForm();

    }

}







