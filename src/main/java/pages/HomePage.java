package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public static final String NAME = "Pruebas de Software 2022";

    @FindBy(css = "#StartSharp_Membership_LoginPanel0_LoginButton")
    private WebElement loginButton;
    @FindBy(xpath = "//*[text()='StartSharp']")
    private WebElement pageTitle;
    @FindBy(css = "#nav_menu1_2 > .s-sidebar-item:nth-child(3) > .s-sidebar-link > .s-sidebar-link-text")
    private WebElement menuOption;
    @FindBy(css = " #nav_menu1_2_3 > .s-sidebar-item:nth-child(3) > .s-sidebar-link > .s-sidebar-link-text")
    private WebElement formOption;
    @FindBy(css = "#nav_menu1_2_3_3 > .s-sidebar-item:nth-child(1) .s-sidebar-link-text")
    private WebElement boostrapOption;
    @FindBy(css = "h3.card-title")
    private WebElement formPageTitle;
    @FindBy(linkText = "New Product")
    private WebElement newProductButton;
    @FindBy(css = "h3.card-title")
    private WebElement newProductPageTitle;
    @FindBy(css = "input[name|='ProductName']")
    private WebElement inputProductName;
    @FindBy(css = "input[name|='QuantityPerUnit']")
    private WebElement inputQuantityPerUnit;
    @FindBy(css = "input[name|='UnitPrice']")
    private WebElement inputUnitPrice;
    @FindBy(css = "input[name|='UnitsInStock']")
    private WebElement inputUnitStick;
    @FindBy(css = "input[name|='UnitsOnOrder']")
    private WebElement inputUnitsOrder;
    @FindBy(css = "input[name|='ReorderLevel']")
    private WebElement inputLevel;
    @FindBy(css = "select[name|='SupplierID']")
    private WebElement selectSuplier;
    @FindBy(css = "select[name|='CategoryID']")
    private WebElement selectCategory;
    @FindBy(xpath = "//body[@id='s-Page']/main/section/div/form/div[2]/button")
    private WebElement btnGuardar;
    @FindBy(css = ".fa-tools")
    private WebElement configurationButtonSideBar;
    @FindBy(linkText = "Roles")
    private WebElement rolesButton;
    @FindBy(css = "div.title-text")
    private WebElement rolesPageTitle;
    @FindBy(css = ".add-button")
    private WebElement newRoleButton;
    @FindBy(css = "#StartSharp_Administration_RoleDialog4")
    private WebElement newRoleDialog;
    @FindBy(css = "input[name|='RoleName']")
    private WebElement inputRoleName;
    @FindBy(css = "input[name|='RoleKey']")
    private WebElement inputRoleKey;
    @FindBy(xpath = "//a[text()='Pruebas de Software 2022']")
    private WebElement dataInTable;
    @FindBy(css = ".save-and-close-button .button-inner")
    private WebElement saveNewRole;
    @FindBy(css=".fa-times")
    private WebElement cancelDialog;
    @FindBy(css=".s-user-profile-link  .s-sidebar-band-icon")
    private WebElement userProfileSideBar;
    @FindBy(css=".show  .dropdown-item:nth-child(3) > span")
    private WebElement logoutButtonSideBar;
    @FindBy(css="h5")
    private WebElement loginPageTitle;
    @FindBy(xpath = "//td[contains(text(),'Pruebas de software 2022')]")
    private WebElement recordJustCreated;
    @FindBy(xpath = "//span[text()='The Product Name field is required.']")
    private WebElement errorMessage;
    @FindBy(css="#StartSharp_Administration_RoleDialog4_RoleName-error")
    private WebElement iconError;
    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://serenity.is/demo/Account/Login");
    }


    public void clickLoginButton() {
        loginButton.click();
    }

    public String getTitltePage() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        salida = pageTitle.getText();
        return salida;
    }

    public void clickAdvancedOptionMenu() {
        menuOption.click();
        formOption.click();
        boostrapOption.click();
    }

    public String getFormPageTitle() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(formPageTitle));
        salida = formPageTitle.getText();
        return salida;
    }

    public void clickNewProductButton() {
        newProductButton.click();
    }

    public String getnewProductPageTitle() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(newProductPageTitle));
        salida = newProductPageTitle.getText();
        return salida;
    }

    public Select findDropdownElement(WebElement dropdown) {
        return new Select(dropdown);
    }

    public void selectDropdownByText(WebElement dropdown, String text) {
        findDropdownElement(dropdown).selectByVisibleText(text);
    }

    public void sendKeysToInputs() {
        inputProductName.sendKeys("Pruebas de software 2022");
        inputQuantityPerUnit.sendKeys("1");
        inputUnitPrice.sendKeys("1000");
        inputUnitStick.sendKeys("2");
        inputLevel.sendKeys("5");
        inputUnitsOrder.sendKeys("10");
        selectSuplier.click();
        selectDropdownByText(selectSuplier, "Cooperativa de Quesos 'Las Cabras'");
        selectCategory.click();
        selectDropdownByText(selectCategory, "Dairy Products");
    }
    public void sendKeysToInputsToFail() {
        inputQuantityPerUnit.sendKeys("1");
        inputUnitPrice.sendKeys("1000");
        inputUnitStick.sendKeys("2");
        inputLevel.sendKeys("5");
        inputUnitsOrder.sendKeys("10");
        selectSuplier.click();
        selectDropdownByText(selectSuplier, "Cooperativa de Quesos 'Las Cabras'");
        selectCategory.click();
        selectDropdownByText(selectCategory, "Dairy Products");
    }

    public void clickSaveButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnGuardar);
        System.out.println(btnGuardar.getText());
        wait.until(ExpectedConditions.elementToBeClickable(btnGuardar));
        btnGuardar.click();
    }
    public void clickIconSideBar() {
        configurationButtonSideBar.click();
        rolesButton.click();
    }

    public String getRolesPageTitle() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(rolesPageTitle));
        salida = rolesPageTitle.getText();
        return salida;
    }

    public void clickNewRoleButtonThenSendKeysAndSaveit() {
        newRoleButton.click();
        wait.until(ExpectedConditions.visibilityOf(inputRoleName));
        inputRoleName.sendKeys(NAME);
        wait.until(ExpectedConditions.visibilityOf(inputRoleKey));
        inputRoleKey.sendKeys("Proyecto final automatización");
        wait.until(ExpectedConditions.visibilityOf(inputRoleKey));
        inputRoleKey.sendKeys("proyecto final 2022");
        wait.until(ExpectedConditions.elementToBeClickable(saveNewRole));
        saveNewRole.click();
    }
    public void clickNewRoleButtonThenSendKeysAndSaveitFail() {
        newRoleButton.click();
        wait.until(ExpectedConditions.visibilityOf(inputRoleName));
        wait.until(ExpectedConditions.visibilityOf(inputRoleKey));
        inputRoleKey.sendKeys("Proyecto final automatización");
        wait.until(ExpectedConditions.visibilityOf(inputRoleKey));
        inputRoleKey.sendKeys("proyecto final 2022");
        wait.until(ExpectedConditions.elementToBeClickable(saveNewRole));
        saveNewRole.click();
    }

    public String roleWasCreateSuccesfully() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(dataInTable));
        salida = dataInTable.getText();
        return salida;
    }

    public void selectRoleCreatedThenCloseDialogAndLogout() throws InterruptedException {
        dataInTable.click();
        Thread.sleep(2500);
        cancelDialog.click();
        userProfileSideBar.click();
        logoutButtonSideBar.click();
    }
    public void failCreateRoleThenLogout() {
        cancelDialog.click();
        userProfileSideBar.click();
        logoutButtonSideBar.click();
    }
    public String logoutSuccesFully() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(loginPageTitle));
        salida = loginPageTitle.getText();
        return salida;
    }

    public String getErrorMessage() {
        String salida;
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        salida = errorMessage.getText();
        return  salida;
    }

    public String forWrong(){
        String salida;
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#StartSharp_Administration_RoleDialog4_RoleName-error")));
        salida=element.getText();
        return salida;
    }

}
