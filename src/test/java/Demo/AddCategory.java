package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddCategory {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang anhtester.com
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sp_2");

        Select parent = new Select(driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select2 form-control aiz-']//select")));
        parent.selectByVisibleText("Demo category 1");

        Select type = new Select(driver.findElement(By.xpath("//label[normalize-space()='Type']/following-sibling::div/div/select")));
        type.selectByIndex(1);

        //banner img
        driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("cp");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='cp_2.jpg']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        //icon img
        driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("ico");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='icon.png']//div[@class='card-body']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("tiennt");
        Select atrribute = new Select(driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div/select")));
        atrribute.selectByIndex(1);
        Thread.sleep(1000);

        //save
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();


        //search
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("sp");
        search.submit();
        Thread.sleep(1000);

        WebElement name = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        String actual = name.getText();
//        System.out.println(actual);

        String expected = "sp_2";

        //so sánh text
        if ( actual.equals(expected)){
            System.out.println("Văn bản chính xác: " + actual);
        } else {
            System.out.println("Văn bản không chính xác. Thực tế:  " + actual);
        }

        //Tắt browser
//        driver.quit();
    }
}
