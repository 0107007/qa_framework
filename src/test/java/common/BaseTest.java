package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

    public class BaseTest {
        private WebDriver driver;

        public WebDriver getDriver() {
            return driver;
        }

        @Before
        public void setDriver(){
            System.setProperty("webdriver.chrome.driver","chromedriver");
            driver = new ChromeDriver();
           driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
        }

        @After
        public void driverClose(){
            driver.close();
        }
    }



