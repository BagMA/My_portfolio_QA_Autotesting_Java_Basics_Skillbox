import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4_4 {
    static WebDriver driver;
    private By nameLoc = By.cssSelector(".form-input.fio");
    private By streetLoc = By.cssSelector(".data.form-input.street");
    private By numberHouseLoc = By.cssSelector(".form-input.house");
    private By numberApartmentLoc = By.cssSelector(".form-input.flat");
    private By dayLoc = By.cssSelector(".form-input.date");
    private By buttonLoc = By.cssSelector(".form-submit");
    private By resultLoc = By.cssSelector(".form-result.result");
    private String name = "Иванов Иван Иванович";
    private String street = "Ленина";
    private String numberHouse = "100";
    private String numberApartment = "33";
    private String day = "Завтра";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fixComputer() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        driver.findElement(nameLoc).sendKeys(name);
        driver.findElement(streetLoc).sendKeys(street);
        driver.findElement(numberHouseLoc).sendKeys(numberHouse);
        driver.findElement(numberApartmentLoc).sendKeys(numberApartment);
        driver.findElement(dayLoc).sendKeys(day);
        driver.findElement(buttonLoc).click();
        Assert.assertTrue("не отобразиласть форма", driver.findElement(resultLoc).isDisplayed());
    }
}
