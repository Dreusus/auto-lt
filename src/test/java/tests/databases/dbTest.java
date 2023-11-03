import io.qameta.allure.Step;
import database.DataBaseConnector;
import org.junit.Test;
import java.sql.SQLException;

public class dbTest {

    @Test
    public void bd(){
        executeOfferStatusCounts();
        executeWebmasterOfferConnectionStatusCounts();
    }

    @Step("Проверка статуса предложений")
    private void executeOfferStatusCounts() {
        try {
            DataBaseConnector.printOfferStatusCounts();
        } catch (SQLException e) {
            failTest("Произошла ошибка при проверке статуса предложений", e);
        }
    }

    @Step("Проверка статуса соединений вебмастера с предложениями")
    private void executeWebmasterOfferConnectionStatusCounts() {
        try {
            DataBaseConnector.printWebmasterOfferConnectionStatusCounts();
        } catch (SQLException e) {
            failTest("Произошла ошибка при проверке статуса соединений вебмастера с предложениями", e);
        }
    }

    @Step("Тест провален: {message}")
    private void failTest(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        throw new AssertionError(message, e);
    }
}
