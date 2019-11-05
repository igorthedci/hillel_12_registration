
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

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class verifyCreateAccount {

    private static WebDriver driver;

    @BeforeClass
    public static void initClass() {
    }

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void stop() {
        driver.close();
    }

    @Test
    public void openSigninPage() {

        pressSigninButton();
        WebElement inputCreateEmail = submitSearch(driver, By.id("email_create"));

        Assert.assertTrue(inputCreateEmail.isDisplayed());
    }

    @Test
    public void openCreateAccountPage() {

        pressSigninButton();
        typeEmailAccount("qq@qq.qq");
        pressCreateAccountButton();

        WebElement divCreateAccount = submitSearch(driver, By.xpath("//h3[text()='Create an account']"));
        Assert.assertTrue(divCreateAccount.isDisplayed());
    }

    @Test
    public void fillMandatoryFields() {

        openCreateAccountPage();

        // YPI === your personal information
        // YA === your address
        typeFirstNameYPI("First");
        typeLastNameYPI("Second");
        typeEmailYPI("qq@qq.qq");
        typePasswordYPI("pa$$w0rd");

        typeFirstNameYA("First");
        typeLastNameYA("Second");
        typeAddressYA("Address1 Address2");
        typeCityYA("City");
        typePostalCodeYA("09876");
        typeMobilePhoneYA("0987654321");
        typeAliasAddressYA("Address3");

        pressRegisterButton();

        WebElement divAlert = submitSearch(driver, By.xpath("//div[contains(@class,'alert')]/p"));
        String expectedAlert = "There is 1 error";
        String actualAlert = divAlert.getText();
        Assert.assertEquals(expectedAlert, actualAlert);
    }

    private WebElement submitSearch(WebDriver driver, By submit_search) {
        return driver.findElement(submit_search);
    }

    private void pressSigninButton() {
        WebElement buttonSignin = submitSearch(driver, By.xpath("//a[contains(text(),'Sign in')]"));
        buttonSignin.click();
    }

    private void pressRegisterButton() {
        WebElement buttonRegister = submitSearch(driver, By.id("submitAccount"));
        buttonRegister.click();
    }

    private void typeEmailAccount(String emailAccount) {
        WebElement inputCreateEmail = submitSearch(driver, By.id("email_create"));
        inputCreateEmail.clear();
        inputCreateEmail.sendKeys(emailAccount);
    }

    private void pressCreateAccountButton() {
        WebElement buttonCreateAccount = submitSearch(driver, By.id("SubmitCreate"));
        buttonCreateAccount.click();
    }

    private void typeFirstNameYPI(String strFirstName) {
        WebElement inputFirstName = submitSearch(driver, By.id("customer_firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys(strFirstName);
    }

    private void typeLastNameYPI(String strLastName) {
        WebElement inputLastName = submitSearch(driver, By.id("customer_lastname"));
        inputLastName.clear();
        inputLastName.sendKeys(strLastName);
    }

    private void typeEmailYPI(String strEmail) {
        WebElement inputEmail = submitSearch(driver, By.id("email"));
        inputEmail.clear();
        inputEmail.sendKeys(strEmail);
    }

    private void typePasswordYPI(String strPassword) {
        WebElement inputPassword = submitSearch(driver, By.id("passwd"));
        inputPassword.clear();
        inputPassword.sendKeys(strPassword);
    }

    private void typeFirstNameYA(String strName) {
        WebElement inputName = submitSearch(driver, By.id("firstname"));
        inputName.clear();
        inputName.sendKeys(strName);
    }
    private void typeLastNameYA(String strName) {
        WebElement inputName = submitSearch(driver, By.id("lastname"));
        inputName.clear();
        inputName.sendKeys(strName);
    }
    private void typeAddressYA(String strAddress) {
        WebElement inputAddress = submitSearch(driver, By.id("address1"));
        inputAddress.clear();
        inputAddress.sendKeys(strAddress);
    }
    private void typeCityYA(String strCity) {
        WebElement inputCity = submitSearch(driver, By.id("city"));
        inputCity.clear();
        inputCity.sendKeys(strCity);
    }
    private void typePostalCodeYA(String strPostalCode) {
        WebElement inputPostalCode = submitSearch(driver, By.id("postcode"));
        inputPostalCode.clear();
        inputPostalCode.sendKeys(strPostalCode);
    }
    private void typeMobilePhoneYA(String strPhone) {
        WebElement inputPhone = submitSearch(driver, By.id("phone_mobile"));
        inputPhone.clear();
        inputPhone.sendKeys(strPhone);
    }
    private void typeAliasAddressYA(String strAddress) {
        WebElement inputAddress = submitSearch(driver, By.id("alias"));
        inputAddress.clear();
        inputAddress.sendKeys(strAddress);
    }

} // class verifyCreateAccount
