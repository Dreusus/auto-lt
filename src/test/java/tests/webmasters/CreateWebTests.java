package tests.webmasters;

import io.qameta.allure.Description;
import org.junit.Test;
import basetest.BaseTest;

public class CreateWebTests extends BaseTest {


    //Это не тест, а предусловие перед тестом - вынести в отдельный шаг целиком
    @Test
    @Description("Создание вебмастера со всеми обязательными параметрами")
    public void createActiveWebMin() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMin(webmaster);  // здесь есть проверка, внутри шага - лучше когда проверка внутри теста, так мы будем видеть где он упал
    }

    @Test
    @Description("Создание веба со всеми возможными параметрами")
    public void createActiveWebMax() {
        navigate.navigateToWebmastersPage();
        webmastersPage.goToWebmasterRegistration();
        webmasterCreationPage.createWebMax(webmaster);
    }


}
