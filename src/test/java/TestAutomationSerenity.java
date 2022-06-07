import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class TestAutomationSerenity extends  BaseTest{

    @Test(groups = {"happyPath"},priority = 2)
    public void loginIntoPageThenEntryANewProduct(){
        homePage.clickLoginButton();
        assertEquals(homePage.getTitltePage(),"StartSharp");
        homePage.clickAdvancedOptionMenu();
        assertEquals(homePage.getFormPageTitle(),"Product List");
        homePage.clickNewProductButton();
        assertEquals(homePage.getnewProductPageTitle(),"New Product");
        homePage.sendKeysToInputs();
        homePage.clickSaveButton();
    }

    @Test(groups = {"happyPath"},priority = 1)
    public void loginIntoPageThenCreateANewUserRole() throws InterruptedException {
        homePage.clickLoginButton();
        assertEquals(homePage.getTitltePage(),"StartSharp");
        homePage.clickIconSideBar();
        assertEquals(homePage.getRolesPageTitle(),"Roles");
        homePage.clickNewRoleButtonThenSendKeysAndSaveit();
        assertEquals(homePage.roleWasCreateSuccesfully(),"Pruebas de Software 2022");
        homePage.selectRoleCreatedThenCloseDialogAndLogout();
        assertEquals(homePage.logoutSuccesFully(),"Login to your account");

    }

    @Test(groups = {"mistakePath"},priority = 2)
    public void loginIntoPageThenEntryANewProductFail(){
        homePage.clickLoginButton();
        assertEquals(homePage.getTitltePage(),"StartSharp");
        homePage.clickAdvancedOptionMenu();
        assertEquals(homePage.getFormPageTitle(),"Product List");
        homePage.clickNewProductButton();
        assertEquals(homePage.getnewProductPageTitle(),"New Product");
        homePage.sendKeysToInputsToFail();
        homePage.clickSaveButton();
        assertEquals(homePage.getErrorMessage(),"The Product Name field is required.");
    }
    @Test(groups = {"mistakePath"},priority = 1)
    public void loginIntoPageThenCreateANewUserRoleFail() throws InterruptedException {
        homePage.clickLoginButton();
        assertEquals(homePage.getTitltePage(),"StartSharp");
        homePage.clickIconSideBar();
        assertEquals(homePage.getRolesPageTitle(),"Roles");
        homePage.clickNewRoleButtonThenSendKeysAndSaveitFail();
        assertEquals(homePage.forWrong(),"This field is required.");
        homePage.failCreateRoleThenLogout();
        assertEquals(homePage.logoutSuccesFully(),"Login to your account");

    }
}
