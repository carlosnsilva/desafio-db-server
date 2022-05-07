package automation.endToend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public static final String URL_LOGIN = "https://demoqa.com/login";

    @FindBy(xpath = ".//*[@id='newUser']")
    private WebElement buttonNewUser;

    public LoginPage(WebDriver driver) {
        super(null);
        PageFactory.initElements(driver,this);
        start(URL_LOGIN);
    }

    public CreateUserPage navigatePageRegister(){
        waitTime(3000);
        WebElement buttonNewUser = findElementByXpath(".//*[@id='newUser']");
        click(buttonNewUser);
        waitTime(5000);

        return new CreateUserPage(driver);
    }
}
