package browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Grid implements IBrowser{
    @Override
    public WebDriver create() {
         WebDriver driver;
         ChromeOptions options = new ChromeOptions();
         DesiredCapabilities capabilities= new DesiredCapabilities();
         capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
