import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class BaseTest {

    static  MyDriver myDriver;
    static  protected HomePage homePage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
        myDriver = new MyDriver(browser);
        homePage = new HomePage(myDriver.getDriver());
    }
}
