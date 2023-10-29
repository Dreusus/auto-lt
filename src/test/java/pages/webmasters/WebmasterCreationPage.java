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
    private SelenideElement email = $("#web-email");
    private SelenideElement firstName = $("#web-firstname");
    private SelenideElement lastName = $("#web-lastname");
    private SelenideElement statusDropdown = $x("//span[@id='select2-web-status-container']");
    private SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private SelenideElement password = $("#web-password");
    private SelenideElement passwordConfirm = $("#web-passwordconfirm");

    //Необязательные
    private SelenideElement phone = $("#web-phone");
    private SelenideElement telegramNick = $("#web-telegramnick");
    private SelenideElement buttonSave = $x("//button[@type='submit' and text()='Сохранить']");
    private SelenideElement middleName = $("#web-middlename");
    private SelenideElement cpaPercent = $("#web-cpapercent");
    private SelenideElement managerIdDropDown = $x("//span[@id='select2-web-managerid-container']");
    private SelenideElement managerId1 = $x("//ul[@id='select2-web-managerid-results']/li[1]");
    public enum WebmasterStatus {
        ACTIVE, NO_ACTIVE, DELETED
    }

    public void enterEmail(WebmasterStatus status) {
        String prefix;
        switch (status) {
            case ACTIVE:
                prefix = "activeWM";
                break;
            case NO_ACTIVE:
                prefix = "noactiveWM";
                break;
            case DELETED:
                prefix = "deleteWM";
                break;
            default:
                throw new IllegalArgumentException("Invalid status: " + status);
        }
        String randomEmail = prefix + "@" + faker.name().firstName().toLowerCase() + ".test";
        email.setValue(randomEmail);
    }

    public void selectStatus(WebmasterStatus status) {
        statusDropdown.click();
        switch (status) {
            case ACTIVE:
                activeStatus.click();
                break;
            case NO_ACTIVE:
                noActiveStatus.click();
                break;
            case DELETED:
                deleteStatus.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid status: " + status);
        }
    }




    public void enterName() {
        String randomName = faker.name().firstName();
        firstName.setValue(randomName);
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



    public void enterPhone() {
        String randomPhone = "7" + faker.number().digits(10);
        phone.setValue(randomPhone);
    }
    public void enterTelegramNick() {
        String randomTg = faker.name().firstName();
        telegramNick.setValue("@" + randomTg);
    }
    public void enterMiddleName() {
        String randomMiddleName = faker.name().firstName();
        middleName.setValue(randomMiddleName);
    }
    public void setCpaPercent() {
        cpaPercent.setValue("10");
    }

    public void selectManager() {
        managerIdDropDown.click();
        managerId1.click();
    }

    public void submitForm() {
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='Редактирование']").shouldBe(visible);
    }



    public void fillRequiredFieldsWebMaster(WebmasterStatus status) {
        enterEmail(status);
        enterName();
        enterLastName();
        enterPassword();
        selectStatus(status);
    }

    public void  createActiveWeb() {
        fillRequiredFieldsWebMaster(WebmasterStatus.ACTIVE);
        setCpaPercent();
        enterTelegramNick();
        enterPhone();
        enterMiddleName();
        //selectManager();
        submitForm();
    }


    public void createNoActiveWeb() {
        fillRequiredFieldsWebMaster(WebmasterStatus.NO_ACTIVE);
        submitForm();
    }


    public void createDeleteWeb() {
        fillRequiredFieldsWebMaster(WebmasterStatus.DELETED);
        submitForm();
    }

}







