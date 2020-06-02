package driver;

import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;


public class Driver
{

    public static WebDriver driver;
    public static final String USERNAME = "avinashravichand2";
    public static final String AUTOMATE_KEY = "DjgL2SGWwDCQhyAWfCUX";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeSpec
    public void initializeDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "83.0");
        caps.setCapability("project", "Gauge_POC");
        caps.setCapability("build", "Gauge_Build");
        caps.setCapability("name", "Gauge_Test");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        java.net.URL BS = new java.net.URL(URL);
        driver = new RemoteWebDriver(BS, caps);

    }

    // Close the webDriver instance
    @AfterSpec
    public void closeDriver()
    {
        driver.quit();
    }

}
