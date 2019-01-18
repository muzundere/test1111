import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.homedepot.pages.HomePage;
import com.homedepot.utils.ConfigurationReader;
import com.homedepot.utils.Driver;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    @Test
    public void test(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        HomePage homePage = new HomePage();

        homePage.searchBox.sendKeys("drill" + Keys.ENTER);



        //driver.close();
    }
}
