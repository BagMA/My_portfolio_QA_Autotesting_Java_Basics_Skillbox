import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void task1() {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        //1.1
        driver.findElement(new By.ByXPath("//div[@class='da-arrows']/span[@class='da-arrows-prev']"));
        var el1 = new By.ByXPath("//div[@class='da-arrows']/span[@class='da-arrows-prev']");
        //1.2
        driver.findElements(new By.ByXPath("//*[@class='da-link button']"));
        //1.3
        driver.findElements(new By.ByXPath("//*[@class='filter']"));
        //1.4
        driver.findElements(new By.ByXPath("//*[starts-with(@class,'button')]"));
        //1.5
        driver.findElement(new By.ByXPath("//a[@href='#'][@class='button']"));
        //1.6
        driver.findElements(new By.ByXPath("//ul/li/a[@href]/img[@src]"));
    }

    @Test
    public void task2() {
        var el1 = new By.ByXPath("(//span[@class='baseCard__title'])[5]");
        var el2 = new By.ByXPath("(//div[@class='baseCondition']/p)[last()]");
        var el3 = new By.ByXPath("//div/*[@href='#']");
        var el4 = new By.ByXPath("(//div/*[@href='#'])[5]");
        var el5 = new By.ByXPath("");
    }

    @Test
    public void task3() {
        var el1 = new By.ByXPath("//a[@href][@test-info='about-us']");
        var el2 = new By.ByXPath("//html/body/ul/li[3]/a");
        var el3 = new By.ByXPath("//input[@id='search-input']");
        var el4 = new By.ByXPath("//*[@id='order-info']/div[1]");
        var el5 = new By.ByXPath("//html/body/div[1]/span[5]/button[2]");
    }
}
