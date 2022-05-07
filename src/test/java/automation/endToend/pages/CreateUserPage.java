package automation.endToend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateUserPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement inputLastName;

    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement inputUserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement checkboxReCaptcha;

    @FindBy(xpath = "//*[@id=\"register\"]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement mensageErrorRegister;

    public CreateUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CreateUserPage registerNewUser(String firstName, String lastName, String userName, String password){
        waitTime(1000);
        moveCursorToClick(inputFirstName);
        fillField(inputFirstName, firstName);

        waitTime(1000);
        moveCursorToClick(inputLastName);
        fillField(inputLastName, lastName);

        waitTime(1000);
        moveCursorToClick(inputUserName);
        fillField(inputUserName, userName);

        waitTime(1000);
        moveCursorToClick(inputPassword);
        fillField(inputPassword, password);

        moveCursorToClick(checkboxReCaptcha);
        moveCursorToClick(buttonRegister);

        return this;
    }

    public void validateResgisterFailed(){
        String mensageStatic = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        String mensageReturn = mensageErrorRegister.getText();

        Assert.assertEquals(mensageStatic, mensageReturn);
        waitTime(3000);
        close();
    }

}
