package basetest;

import Objects.Webmaster;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import pages.Navigate;
import pages.login.LoginPage;
import pages.webmasters.WebmasterCreationPage;
import pages.webmasters.WebmastersPage;

import static com.codeborne.selenide.Selenide.open;
import static config.Constants.*;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected static Navigate navigate;
    protected static WebmastersPage webmastersPage;
    protected static WebmasterCreationPage webmasterCreationPage;
    protected static Webmaster webmaster;


    @BeforeClass
    public static void setupWebDriver() {
        Configuration.browser = "chrome";

        navigate = new Navigate();
        webmaster = new Webmaster();
        webmastersPage = new WebmastersPage();
        webmasterCreationPage = new WebmasterCreationPage();

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
