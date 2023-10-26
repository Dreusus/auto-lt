package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Navigate {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='dropdown']/a[text()='Вебмастера ']")
    private WebElement webmastersNavigationLink;

    @FindBy(xpath = "//ul/li/a[text()='Вебмастера']")
    private WebElement webmasterDropDownLink;

    @FindBy(xpath = "//li[@class='dropdown']/a[text()='Рекламодатели ']")
    private WebElement advertiserNavigationLink;

    @FindBy(xpath = "//ul/li/a[text()='Офферы']")
    private WebElement offersDropDownLink;
    public Navigate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToWebmastersPage() {
        webmastersNavigationLink.click();
        webmasterDropDownLink.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://adm.st.leads.tech/webmaster/index/", currentUrl);
    }

    public void naviagateToOffersPage() {
        advertiserNavigationLink.click();
        offersDropDownLink.click();
    }
}

