package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.id("loginform-email");
    private By passwordField = By.id("loginform-password");
    private By loginButton = By.xpath("//button[@name='login-button']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://adm.st.leads.tech/"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://adm.st.leads.tech/", currentUrl);
    }




}
