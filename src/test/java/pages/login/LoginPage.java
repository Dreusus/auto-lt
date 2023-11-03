package pages.login;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;

public class LoginPage {

    private SelenideElement emailField = $("#loginform-email");
    private SelenideElement passwordField = $("#loginform-password");
    private SelenideElement loginButton = $x("//button[@name='login-button']");

    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
