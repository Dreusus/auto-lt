package pages.webmasters;

import Objects.Webmaster;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class WebmasterCreationPage {

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

    public void selectStatus() {
        statusDropdown.click();
        activeStatus.click();
    }
    public void selectWebGroup() {
        webGroupDropDown.click();
        webGroup1.click();
    }

    public void selectLegalEntity() {
        legalEntityDropDown.click();
        legalEntity1.click();
    }
    public void selectManager() {
        managerIdDropDown.click();
        managerId1.click();
    }


    public void submitForm() {
        buttonSave.click();
        $x("//ul/li[@class='active' and text()='Редактирование']").shouldBe(visible);
    }
    public void fillRequiredFieldsWebMaster(Webmaster webmaster) {
        email.setValue(webmaster.getEmail());
        firstName.setValue(webmaster.getFirstName());
        lastName.setValue(webmaster.getLastName());
        password.setValue(webmaster.getPassword());
        passwordConfirm.setValue(webmaster.getPasswordConfirm());
        selectStatus();
    }

    public void  createWebMin(Webmaster webmaster) {
        fillRequiredFieldsWebMaster(webmaster);
        submitForm();
    }

    public void createWebMax(Webmaster webmaster) {
        fillRequiredFieldsWebMaster(webmaster);
        phone.setValue(webmaster.getPhone());
        middleName.setValue(webmaster.getMiddleName());
        selectManager();
        selectWebGroup();
        selectLegalEntity();
        cpaPercent.setValue(webmaster.getCpaPercent());
        refPercent.setValue(webmaster.getRefPercent());
        telegramChatId.setValue(webmaster.getTelegramChatId());
        webTraffic.setValue(webmaster.getWebTraffic());
        webTimeZone.setValue(webmaster.getWebTimeZone());
        webOrgMode.setValue(webmaster.getWebOrgMode());
        webSkill.setValue(webmaster.getWebSkill());
        webPayForm.setValue(webmaster.getWebPayForm());
        webOthersContacts.setValue(webmaster.getWebOthersContacts());
        telegramNick.setValue(webmaster.getTelegramNick());
        submitForm();
    }

}







