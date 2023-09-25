package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang anhtester.com
        driver.get("https://cms-blog.farmme.io/login");

        //Login
        driver.findElement(By.xpath("//label[contains(text(),'Tên đăng nhập hoặc email')]/following-sibling::input")).sendKeys("admin");
        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu')]/following-sibling::input")).sendKeys("Paditech1@3$");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
        Thread.sleep(1000);

        //Create account
        driver.findElement(By.xpath("//span[contains(text(),'Quản lý tài khoản quản trị')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Thêm mới tài khoản')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),'Tên đăng nhập')]/following-sibling::input")).sendKeys("test123");
        driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::input")).sendKeys("test123@gmail.com");
        driver.findElement(By.xpath("//label[contains(text(),'Họ và tên')]/following-sibling::input")).sendKeys("Automation");
        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu')]/following-sibling::div/input")).sendKeys("123456");


        driver.findElement(By.xpath("//div[@class='form-group ']//label[1]/following-sibling::span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-results']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Số điện thoại')]/following-sibling::input")).sendKeys("0912345678");
        driver.findElement(By.xpath("//input[@placeholder='DD/MM/YYYY']")).sendKeys("01/01/2000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Lưu')]")).click();
        Thread.sleep(10000);


        //logout
        driver.findElement(By.xpath("//span[@class='main-img-user']")).click();
        driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();

        Thread.sleep(2000);


        //Tắt browser
        driver.quit();
    }
}
