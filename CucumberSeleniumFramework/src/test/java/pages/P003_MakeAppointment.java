package pages;

import com.cucumber.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class P003_MakeAppointment extends BasePage {

    @FindBy(how = How.ID, using = "combo_facility")
    public WebElement ddFacility;

    @FindBy(how = How.ID, using = "chk_hospotal_readmission")
    public WebElement chkBoxApplyHospital;

    @FindBy(how = How.ID, using = "radio_program_medicare")
    public WebElement radioHealthCarePRG_1;

    @FindBy(how = How.ID, using = "radio_program_medicare")
    public WebElement radio_program_medicaid;

    @FindBy(how = How.ID, using = "radio_program_medicare")
    public WebElement radio_program_none;

    public void WaitOnPage(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean IsMakeAppointmentPage(){
        return ddFacility.isDisplayed();
    }

}
