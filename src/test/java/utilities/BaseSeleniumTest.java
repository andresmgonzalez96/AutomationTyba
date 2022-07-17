package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseSeleniumTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public static String URL_BASE = "https://www.advantageonlineshopping.com/";
    public static String url;
    
    @Before
    public void init() throws MalformedURLException {
        String flag = "Windows";
        if(flag == "Windows") {
            System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
            driver = new ChromeDriver();
        } 

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 60);
        
        navigateTo(URL_BASE);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void navigateTo(String url){
        driver.get(url);
    }
}
