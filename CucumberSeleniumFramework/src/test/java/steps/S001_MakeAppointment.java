package steps;

import com.cucumber.framework.base.Base;
import com.cucumber.framework.base.DriverContext;
import com.cucumber.framework.utilities.CucumberUtil;
import pages.P001_LandingPage;
import pages.P002_LoginPage;
import pages.P003_MakeAppointment;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class S001_MakeAppointment extends Base {
    @When("^I should see application loaded properly$")
    public void iShouldSeeApplicationLoadedProperly() throws Throwable {
        CurrentPage = GetInstance(P001_LandingPage.class);
        Assert.assertTrue("Landing Page is not loaded", CurrentPage.As(P001_LandingPage.class).IsLandingPage());
    }

    @When("^I click on Make Appointment button$")
    public void iClickOnMakeAppointmentButton() throws Throwable {
        CurrentPage = CurrentPage.As(P001_LandingPage.class).Goto_MakeAppointment();
        DriverContext.WaitForPageToLoad();
    }

    @Then("^I should navigate to the login page$")
    public void iShouldNavigateToTheLoginPage() throws Throwable {
        Assert.assertTrue("Login Page is not loaded", CurrentPage.As(P002_LoginPage.class).IsLoginPage());
    }

    @And("^I should see login page loaded properly$")
    public void iShouldSeeLoginPageLoadedProperly() throws Throwable {
        Assert.assertTrue("Username field is not visible", CurrentPage.As(P002_LoginPage.class).txtUsername.isDisplayed());
        Assert.assertTrue("Password field is not visible", CurrentPage.As(P002_LoginPage.class).txtPassword.isDisplayed());
    }

    @When("^I entered my username and password$")
    public void iEnteredMyUsernameAndPassword(DataTable data) throws Throwable {
//        List<List<String>> table = data.raw();
//        CurrentPage = CurrentPage.As(LoginPage.class).Login(table.get(1).get(0), table.get(1).get(1));
        CucumberUtil.CovertDataTableToListData(data);
        CurrentPage = CurrentPage.As(P002_LoginPage.class).Login(
                CucumberUtil.GetCellValueWithRowIndex("username",1),
                CucumberUtil.GetCellValueWithRowIndex("password",1));
        DriverContext.WaitForPageToLoad();
    }

    @Then("^I should navigated to the make appointment page$")
    public void iShouldNavigatedToTheMakeAppointmentPage() throws Throwable {
        Assert.assertTrue("Password field is not visible", CurrentPage.As(P003_MakeAppointment.class).IsMakeAppointmentPage());
    }

    @And("^I should see make appointment page loaded properly$")
    public void iShouldSeeMakeAppointmentPageLoadedProperly() throws Throwable {
        Assert.assertTrue("Facility dropdown is not visible", CurrentPage.As(P003_MakeAppointment.class).ddFacility.isDisplayed());
        Assert.assertTrue("Apply for hospital readmission checkbox is not visible", CurrentPage.As(P003_MakeAppointment.class).chkBoxApplyHospital.isDisplayed());
    }
}
