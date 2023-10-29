package tests;


import database.DataBaseConnector;

import org.junit.Test;
import pages.Navigate;
import pages.advertiser.OfferCreationPage;
import pages.advertiser.OffersPage;

import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.sleep;

public class OffersTests extends BaseTest {

    private Navigate navigate;
    private OffersPage offersPage;
    private OfferCreationPage offerCreationPage;

    public OffersTests() {
        navigate = new Navigate();
        offersPage = new OffersPage();
        offerCreationPage = new OfferCreationPage();
    }

    @Test
    public void createOfferActive() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(2000);

        try {
            DataBaseConnector.printWebmasterStatusCount();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createOfferPrivate() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferPrivate();
        sleep(2000);
        try {
            DataBaseConnector.printWebmasterStatusCount();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createOfferNoActive() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferNoActive();
        try {
            DataBaseConnector.printWebmasterStatusCount();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void createOfferDelete() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferDelete();
        try {
            DataBaseConnector.printWebmasterStatusCount();
            DataBaseConnector.printOfferWebmasterConnectionStatusCounts();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void editCreatedOffer() {
        navigate.navigateToOffersPage();
        offersPage.goToOfferRegistration();
        offerCreationPage.createOfferActive();
        sleep(2000);
        try {
            DataBaseConnector.printOfferCreatedDates();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
        offerCreationPage.editOffer("Active_Rename","reslug","222222","222222","0","20","1");
        sleep(2000);
        try {
            DataBaseConnector.printOfferCreatedDates();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при работе с базой данных: " + e.getMessage());
        }
    }

}
