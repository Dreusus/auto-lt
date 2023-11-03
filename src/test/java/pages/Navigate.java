package pages;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class Navigate {

    //Статистика:
    private static final String STAT_BUTTON = "//li//a[text()='Статистика ']";
    private static final String STAT_BY_DAY = "//a[@href='/stat/by-day/']";
    private static final String STAT_BY_DAY_HOUR = "//a[@href='/stat/by-day-hour/']";
    private static final String STAT_BY_MONTH = "//a[@href='/stat/by-month/']";
    private static final String STAT_BY_OFFER = "//a[@href='/stat/by-offer/']";
    private static final String STAT_BY_WEB = "//a[@href='/stat/by-webmaster/']";
    private static final String STAT_BY_SUBID = "//a[@href='/stat/by-subid/']";
    private static final String STAT_BY_BUILDER = "//a[@href='/stat/by-builder/']";

    //Трекинг:
    private static final String TRACK_BUTTON = "//li//a[text()='Трекинг ']";
    private static final String TRACK_CLICK ="//a[contains(@href, '/click/')]";
    private static final String TRACK_CONVERSION = "//a[contains(@href, 'conversion')]";
    private static final String TRACK_TRANSACTION = "//a[@href ='/transaction/index/']";
    private static final String TRACK_FILE_LOAD ="//a[@href ='/conversion-file-load/index/']";
    private static final String TRACK_COMPARE_FILE ="//a[@href ='/conversion-compare-file/index/']";

    //Рекламодатели:
    private static final String ADV_BUTTON = "//li[@class='dropdown']/a[text()='Рекламодатели ']";
    private static final String ADV_OFFER = "//ul/li/a[text()='Офферы']";
    private static final String ADV_OFFER_CATEGORY = "//a[@href='/offer-category/index/']";
    private static final String ADV_ADVERTISER_LIST = "//a[@href='/advertiser/index/']" ;
    private static final String ADV_TRAFFICBACK = "//a[@href='/traffic-back/index/']";
    private static final String ADV_PROMO ="//a[@href='/promo/list/index/']";
    private static final String ADV_PROMO_TASK ="//a[@href='/promo/task/index/']";
    private static final String ADV_PROMO_TRANSCATION ="//a[@href='/promo/transaction/index/']";
    

    //Вебмастеры:
    private static final String WEB_BUTTON= "//li//a[text()='Вебмастера ']";
    private static final String WEB_WEBMASTER ="//a[@href='/webmaster/index/']";
    private static final String WWB_WEBMASTER_GROUP ="//a[@href='/webmaster-group/index/']" ;
    private static final String WEB_WEBMASTER_LEAD  = "//a[@href='/webmaster-lead/index/']";
    private static final String WEB_POSTBACK  = "//a[@href='/webmaster-postback/index/']";
    private static final String WEB_POSTBACK_LOG = "//a[@href='/webmaster-postback-log/index/']";

    @Step("Переход в раздел Вебмастера/Вебмастера")
    public void navigateToWebmastersPage() {
        $x(WEB_BUTTON).click();
        $x(WEB_WEBMASTER).click();
    }

    @Step("Переход в раздел Рекламодатели/Офферы")
    public void navigateToOffersPage() {
        $x(ADV_BUTTON).click();
        $x(ADV_OFFER).click();
    }
}
