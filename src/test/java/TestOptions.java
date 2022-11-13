import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.getProperties;

public class TestOptions {

    static{
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setWindowDimensions(int a, int b){
        Dimension dimension = new Dimension(a, b);
        getDriver().manage().window().setSize(dimension);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        setWindowDimensions(1920, 1080);

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
