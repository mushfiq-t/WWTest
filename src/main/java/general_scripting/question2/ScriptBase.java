package general_scripting.question2;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScriptBase {

    protected WebDriver driver;

    protected FoodItemPage foodItemPage;


    @BeforeMethod
    public void beforeMethod(){

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        foodItemPage = new FoodItemPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("FOOD_ITEM_WEBSITE");
    }


    @AfterMethod
    public void afterMethod(){

        driver.close();
        driver.quit();
    }
}
