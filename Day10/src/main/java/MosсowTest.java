import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MosсowTest {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.navigate().to("https://www.booking.com");
        WebElement element = driver.findElement(By.name("ss"));
        element.sendKeys("Москва");
        driver.manage().window().maximize();
        WebElement ul = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        ul.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDays = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fifteenDays = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTenDays = dateFormat.format(tenDays);
        String datePlusfifteenDays = dateFormat.format(fifteenDays);

        WebElement dateFrom = driver.findElement(By.xpath(String.format
                ("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateFrom.click();

        WebElement dateTo = driver.findElement(By.xpath(String.format
                ("//*[contains(@data-date,'%s')]", datePlusfifteenDays)));
        dateTo.click();

        WebElement adults = driver.findElement(By.xpath("//label[@id='xp__guests__toggle']"));
        Actions action = new Actions(driver);
        action.click(adults).perform();

        WebElement choise = driver.findElement(By.xpath("//button[2]/span[@class='bui-button__text']"));
        action.doubleClick(choise).perform();

        WebElement room = driver.findElement
                (By.xpath("//div[@class=\"sb-group__field sb-group__field-rooms\"]/descendant::span[3]"));
        action.click(room).perform();

        WebElement price = driver.findElement(By.xpath("//button[@data-sb-id='main']"));
        price.click();

        WebElement sortPrice = driver.findElement
                (By.xpath("//div[@class=\"bui-checkbox__label filter_item css-checkbox\"]"));
        sortPrice.click();
        Thread.sleep(10000);

        WebElement cheapHotels = driver.findElement
                (By.xpath("//div[@class='bui-checkbox__label filter_item css-checkbox']/span"));
        String cheaphot = cheapHotels.getText();
        System.out.println(cheaphot);
        cheaphot = cheaphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(cheaphot);
        System.out.println(priceHotelDay);

        WebElement hotel = driver.findElement
                (By.xpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper']"));
        String priceTextFinal = hotel.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceDay = Integer.parseInt(priceTextFinal) / 5;
        System.out.println(priceDay);

        System.out.println("drivers gone...");
        Assert.assertTrue("Information about price is incorrect", priceDay <= priceHotelDay);
    }
}
