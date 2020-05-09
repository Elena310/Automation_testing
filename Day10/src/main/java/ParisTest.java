import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParisTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException, NumberFormatException {
        driver.navigate().to("https://booking.com/");
        WebElement el = driver.findElement(By.name("ss"));
        el.sendKeys("Париж");
        driver.manage().window().maximize();
        WebElement ul = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        ul.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);

        WebElement dateFrom = driver.findElement(By.xpath(String.format
                ("//*[contains(@data-date,'%s')]", datePlusThreeDays)));
        dateFrom.click();

        WebElement dateTo = driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateTo.click();

        WebElement adults = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        adults.click();

        WebElement choise = driver.findElement(By.xpath("//button[2]/span[@class='bui-button__text']"));
        choise.click();
        choise.click();

        WebElement room = driver.findElement(By.xpath
                ("//div[@class=\"sb-group__field sb-group__field-rooms\"]/descendant::span[3]"));
        room.click();

        WebElement price = driver.findElement(By.xpath("//button[@data-sb-id='main']"));
        price.click();

        WebElement sortPrice1 = driver.findElement(By.xpath("//a[@data-id='pri-5']/label/div"));
        sortPrice1.click();

        WebElement sortPrice2 = driver.findElement(By.xpath("//div[@id='sort_by']/ul/li[3]/a"));
        sortPrice2.click();
        Thread.sleep(10000);

        WebElement expensiveHotels = driver.findElement(By.xpath("//a[@data-id='pri-5']/label/div/span"));
        String exphot = expensiveHotels.getText();
        System.out.println(exphot);
        exphot = exphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(exphot);
        System.out.println(priceHotelDay);

        WebElement hotel = driver.findElement(By.xpath("//div[2][@class=\"prco-ltr-right-align-helper\"]/div"));

        String priceTextFinal = hotel.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceDay = Integer.parseInt(priceTextFinal) / 7;
        System.out.println(priceDay);

        System.out.println("drivers gone...");
        Assert.assertTrue("Information about price is incorrect", priceDay >= priceHotelDay);
    }
}
