package pages.webmasters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class WebmastersPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Регистрация вебмастера']")
    private WebElement createWebButton;


    public WebmastersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createWebmasterActive() {
    createWebButton.click();
    String currentUrl = driver.getCurrentUrl();
    assertEquals("http://adm.st.leads.tech/webmaster/create/", currentUrl);

    WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage(driver);
    webmasterCreationPage.generateActiveWeb();

    }

    public void createWebmasterNoActive() {
    createWebButton.click();
    String currentUrl = driver.getCurrentUrl();
    assertEquals("http://adm.st.leads.tech/webmaster/create/", currentUrl);
    WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage(driver);
    webmasterCreationPage.generateNoActiveWeb();

    }
    public void createWebmasterDelete() {
        createWebButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://adm.st.leads.tech/webmaster/create/", currentUrl);
        WebmasterCreationPage webmasterCreationPage = new WebmasterCreationPage(driver);
        webmasterCreationPage.generateDeleteWeb();

    }
}


