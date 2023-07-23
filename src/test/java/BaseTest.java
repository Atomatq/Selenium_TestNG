import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver webDriver;
    Properties prop;

    @BeforeTest
    public void init() {
        webDriver = WebDriverManager.chromedriver().driverVersion("109.0.5414.74").create();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
    }

    @AfterTest
    public void shutDown() {
        webDriver.quit();
    }

    private void getProperty() {
        prop = new Properties();
        try {
            String resource = System.getProperty("application.properties", "debug.properties");
            prop.load(BaseTest.class.getResourceAsStream(resource));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
