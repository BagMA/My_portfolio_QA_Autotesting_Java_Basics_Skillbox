import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class taskThree {
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testFirst() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(By.cssSelector("section.important-section-block[for='main-header-page'] > h1:first-child"));
    }

    @Test
    public void testTwo() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(By.cssSelector("form#login-form.form > p:last-child"));
    }

    @Test
    public void testThree() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(By.cssSelector("body > *:nth-child(3)"));
    }

    @Test
    public void testFour() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElements(By.cssSelector("div.footer__menuList > a:nth-of-type(1)"));
    }

    @Test
    public void testFive() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(By.cssSelector("div.footer__menu > div.footer__menuList:first-of-type > a:nth-of-type(1)"));
    }
}
