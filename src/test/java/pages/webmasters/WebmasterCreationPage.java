package pages.webmasters;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class WebmasterCreationPage {
    private WebDriver driver;
    private Faker faker;

    @FindBy(id = "web-email")
    private WebElement email;
    @FindBy(id = "web-phone")
    private WebElement phone;
    @FindBy(id = "web-firstname")
    private WebElement firstName;

    @FindBy(id="web-lastname")
    private WebElement lastName;
    @FindBy(xpath="//span[text()='Выберите статус...']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//ul/li[text()='Активен']")
    private WebElement activeStatus;
    @FindBy(xpath = "//ul/li[text()='Неактивен']")
    private WebElement noActiveStatus;
    @FindBy(xpath = "//ul/li[text()='Удален']")
    private WebElement deleteStatus;

    @FindBy(id="web-password")
    private WebElement password;
    @FindBy(id="web-passwordconfirm")
    private WebElement passwordConfirm;
    @FindBy(id="web-telegramnick")
    private WebElement telegramNick;
    @FindBy(xpath = "//button[@type='submit' and text()='Сохранить']")
    private WebElement buttonSave;

    @FindBy(id="web-middlename")
    private WebElement middleName;

    @FindBy(id="web-cpapercent")
    private WebElement cpaPercent;


    public  WebmasterCreationPage(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        PageFactory.initElements(driver, this);
    }

    public void sendEmail() {
        String randomEmail = "activeWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.sendKeys(randomEmail);
    }
    public void sendEmailNoactive() {
        String randomEmail = "noactiveWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.sendKeys(randomEmail);
    }
    public void sendEmailDelete() {
        String randomEmail = "deleteWM@" + faker.name().firstName().toLowerCase() + ".test";
        email.sendKeys(randomEmail);
    }

    public void sendPhone() {
        String randomPhone =   "7" + faker.number().digits(10);
        phone.sendKeys(randomPhone);
    }



    public void sendName() {
        String randomName = faker.name().firstName();
        firstName.sendKeys(randomName);
    }

    public void sendLastName() {
        String randomLastName = faker.name().lastName();
        lastName.sendKeys(randomLastName);
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
        password.sendKeys(randomPassword);
        passwordConfirm.sendKeys(randomPassword);
    }

    public void sendTelegramNick() {
        String randomTg = faker.name().firstName();
        telegramNick.sendKeys("@" + randomTg);
    }

    public void submitForm() {
        buttonSave.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMiddleName() {
        String randomMiddleName =faker.name().firstName();
        middleName.sendKeys(randomMiddleName);
    }

    public void setCpaPercent() {
        cpaPercent.sendKeys("10");
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
