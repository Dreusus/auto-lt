package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import pages.login.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static config.Constants.*;

public abstract class BaseTest {

    protected LoginPage loginPage;

    @BeforeClass
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    @Before
    public void setup() {
        open(STAND_1);
        loginPage = new LoginPage();
        loginPage.login(LOGIN_EMAIL, LOGIN_PASSWORD);
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
