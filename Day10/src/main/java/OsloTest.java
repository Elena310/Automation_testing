import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OsloTest {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException, NumberFormatException {
        driver.navigate().to("https://booking.com/");

        WebElement el = driver.findElement(By.name("ss"));
        el.sendKeys("Осло");
        driver.manage().window().maximize();
        WebElement ul = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        ul.click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date oneDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date twoDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusOneDay = dateFormat.format(oneDay);
        String datePlusTwoDays = dateFormat.format(twoDays);

        WebElement dateFrom = driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusOneDay)));
        dateFrom.click();
        WebElement dateTo = driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTwoDays)));
        dateTo.click();

        WebElement choise = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        choise.click();
        WebElement children = driver.findElement(By.xpath("//descendant::button[4]"));
        children.click();
        WebElement price = driver.findElement(By.xpath("//button[@data-sb-id='main']"));
        price.click();
        Thread.sleep(1000);

        WebElement stars3 = driver.findElement(By.xpath("//a[@data-id=\"class-3\"]"));
        stars3.click();
        Thread.sleep(2000);
        WebElement stars4 = driver.findElement(By.xpath("//a[@data-id='class-4']"));
        stars4.click();
        Thread.sleep(5000);

        WebElement hotel = driver.findElement(By.xpath("//div[contains(@class, 'sr_item_default')][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", hotel);
        Thread.sleep(4000);

        WebElement address = driver.findElement
                (By.xpath("//descendant::div[contains(@class, 'sr_card_address_line')][10]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(address).build().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", address);
        Assert.assertEquals("Color of address text is not correct",
                "rgba(255, 0, 0, 1)", address.getCssValue("color"));
    }
}