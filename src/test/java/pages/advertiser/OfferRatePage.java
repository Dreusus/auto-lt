package pages.advertiser;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class OfferRatePage {
    private final SelenideElement rateInput = $x("//input[@placeholder='Выберите цель...']");
    private final SelenideElement rateClickToOffer = $x("//li[text() ='1 Клик по офферу']");
    private final SelenideElement rateAdvertiser = $x("//input[@name='in']");
    private final SelenideElement buttonSave = $x("//button[@id='save']");

    public void setRateClick() {
        rateInput.shouldBe(Condition.visible, Duration.ofSeconds(10));
        rateInput.click();
        rateClickToOffer.click();
    }

    public void setRateAdvertiser() {
        rateAdvertiser.setValue("6666");
    }
    public void createRate() {
        setRateClick();
        setRateAdvertiser();
        buttonSave.click();
        $x("//a[@id='percent-set-btn']").shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
