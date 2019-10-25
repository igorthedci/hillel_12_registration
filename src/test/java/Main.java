import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Открыть главную страницу automationpractice.com
 * Открыть форму регистрации нового клиента (Sign in )
 * В секции Create an account ввести корректный емейл
 * Нажать Create an account
 * На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ
 * выпадающих списков
 * Нажать Register
 * Проверить что сообщение валидации содержит текст ,
 * например “There are 3 errors”
 */
public class Main {

    public static void main(String[] args) {

    }

    public static void runDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\!Setup\\Dev\\Webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        driver.close();
    }
}
