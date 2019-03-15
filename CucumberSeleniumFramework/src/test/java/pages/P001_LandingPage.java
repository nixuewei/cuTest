package pages;

import com.cucumber.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class P001_LandingPage extends BasePage {

//    public P001_LandingPage(){
//    }

    @FindBy(how = How.ID, using = "btn-make-appointment")
    public WebElement btnMakeAppointment;

    public BasePage Goto_MakeAppointment(){
        btnMakeAppointment.click();
        return GetInstance(P002_LoginPage.class);
    }

    public boolean IsLandingPage(){
        return btnMakeAppointment.isDisplayed();
    }
}
