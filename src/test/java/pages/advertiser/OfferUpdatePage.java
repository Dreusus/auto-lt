package pages.advertiser;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

//http://adm.st.leads.tech/offer/update/?id=
//Редактирование полей оффера
public class OfferUpdatePage {
    private String offerId;
    private SelenideElement rate;

    public OfferUpdatePage(String offerId) {
        this.offerId = offerId;
        this.rate = $x("//a[contains(@href, '/rate/offer/?offerId=" + offerId + "')]");
    }
    public void navigateToOfferRatePage() {
        rate.click();
    }
}
