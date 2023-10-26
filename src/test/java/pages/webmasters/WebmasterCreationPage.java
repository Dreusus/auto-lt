package pages.webmasters;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;

public class WebmasterCreationPage {

    private Faker faker = new Faker();

    private SelenideElement email = $("#web-email");
    private SelenideElement phone = $("#web-phone");
    private SelenideElement firstName = $("#web-firstname");
    private SelenideElement lastName = $("#web-lastname");
    private SelenideElement statusDropdown = $x("//span[text()='Выберите статус...']");
    private SelenideElement activeStatus = $x("//ul/li[text()='Активен']");
    private SelenideElement noActiveStatus = $x("//ul/li[text()='Неактивен']");
    private SelenideElement deleteStatus = $x("//ul/li[text()='Удален']");
    private SelenideElement password = $("#web-password");
    private SelenideElement passwordConfirm = $("#web-passwordconfirm");
    private SelenideElement telegramNick = $("#web-telegramnick");
    private SelenideElement buttonSave = $x("//button[@type='submit' and text()='Сохранить']");
    private SelenideElement middleName = $("#web-middlename");
    private SelenideElement cpaPercent = $("#web-cpapercent");

    public void sendEmail() {
        String randomEmail = "activeWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.setValue(randomEmail);
    }

    public void sendEmailNoactive() {
        String randomEmail = "noactiveWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.setValue(randomEmail);
    }

    public void sendEmailDelete() {
        String randomEmail = "deleteWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.setValue(randomEmail);
    }

    public void sendPhone() {
        String randomPhone = "7" + faker.number().digits(10);
        phone.setValue(randomPhone);
    }

    public void sendName() {
        String randomName = faker.name().firstName();
        firstName.setValue(randomName);
    }

    public void sendLastName() {
        String randomLastName = faker.name().lastName();
        lastName.setValue(randomLastName);
    }

    public void selectStatusActive() {
        statusDropdown.click();
        activeStatus.click();
    }

    public void selectStatusNoActive() {
        statusDropdown.click();
        noActiveStatus.click();
    }

    public void selectStatusDelete() {
        statusDropdown.click();
        deleteStatus.click();
    }

    public void sendPassword() {
        String randomPassword = faker.internet().password(6,8,true,true,true);
        password.setValue(randomPassword);
        passwordConfirm.setValue(randomPassword);
    }

    public void sendTelegramNick() {
        String randomTg = faker.name().firstName();
        telegramNick.setValue("@" + randomTg);
    }

    public void submitForm() {
        buttonSave.click();
        sleep(3000); // You can use Selenide's sleep, but ideally you'd want to replace this with a more deterministic wait
    }

    public void sendMiddleName() {
        String randomMiddleName = faker.name().firstName();
        middleName.setValue(randomMiddleName);
    }

    public void setCpaPercent() {
        cpaPercent.setValue("10");
    }

    public void generateActiveWeb() {
        sendEmail();
        sendPhone();
        sendName();
        sendLastName();
        sendPassword();
        sendTelegramNick();
        selectStatusActive();
        sendMiddleName();
        setCpaPercent();
        submitForm();
    }

    public void generateNoActiveWeb() {
        sendEmailNoactive();
        sendPhone();
        sendName();
        sendLastName();
        sendPassword();
        sendTelegramNick();
        selectStatusNoActive();
        submitForm();
    }

    public void generateDeleteWeb() {
        sendEmailDelete();
        sendPhone();
        sendName();
        sendLastName();
        sendPassword();
        sendTelegramNick();
        selectStatusDelete();
        submitForm();
    }
}
