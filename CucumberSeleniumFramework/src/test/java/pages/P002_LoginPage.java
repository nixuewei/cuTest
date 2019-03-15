package pages;

import com.cucumber.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class P002_LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "txt-username")
    public WebElement txtUsername;

    @FindBy(how = How.ID, using = "txt-password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "btn-login")
    public WebElement btnLogin;

    public BasePage Login(String username, String password){
        txtUsername.clear();
        txtUsername.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnLogin.click();
        return GetInstance(P003_MakeAppointment.class);
    }

    public boolean IsLoginPage(){
        return txtUsername.isDisplayed();
    }
}
