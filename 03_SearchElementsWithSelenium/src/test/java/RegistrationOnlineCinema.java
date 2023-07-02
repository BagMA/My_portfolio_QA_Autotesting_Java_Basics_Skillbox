import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationOnlineCinema {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.findElement(By.name("name")).sendKeys("Миша");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        String expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        String actualResult = driver.findElement(By.className("form-result")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondTest() {
        driver.findElement(By.className("form-submit")).click();
        String actualResult =driver.findElement(By.className("form-error")).getText();
        String expectedResult = "Введите имя";
        Assert.assertEquals(expectedResult, actualResult);
    }
}
