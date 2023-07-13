import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

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
    public void testOne() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By testInfo = By.cssSelector("[test-info='about-us']");
        driver.findElement(testInfo);

    }

    @Test
    public void testTwo() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By aHref = By.cssSelector("a[href='']");
        driver.findElements(aHref);
    }

    @Test
    public void testThree() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        By selected = By.cssSelector("[selected]");
        driver.findElement(selected);
    }

    @Test
    public void testFour() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By divBookPrice = By.cssSelector("div.book-price");
        driver.findElement(divBookPrice);

    }

    @Test
    public void testFive() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By but = By.cssSelector("button[class^='book']");
        driver.findElements(but);

    }

    @Test
    public void testSix() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By main = By.cssSelector("[class$='main']");
        driver.findElements(main);
    }

    @Test
    public void testSeven() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By menu = By.cssSelector("[class*='menu']");
        driver.findElements(menu);
    }


}
