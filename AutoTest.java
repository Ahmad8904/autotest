import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class AutoTest {
    WebDriver driver;
    String username;
    String password;
    String domain;
    String url;

    @Test
    public void launch() {

        username = "admin";
        password = "admin";
        domain = "the-internet.herokuapp.com/basic_auth";

        url = "https://" + username + ":" + password + "@" + domain;

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        String text = driver.findElement(By.cssSelector("div.example p")).getText().trim();
        Assert.assertEquals(text, "Congratulations! You must have the proper credentials.");

        driver.quit();
    }
}
