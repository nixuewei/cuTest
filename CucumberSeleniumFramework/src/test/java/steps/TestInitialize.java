package steps;

import com.cucumber.framework.base.DriverContext;
import com.cucumber.framework.base.FrameworkInitialize;
import com.cucumber.framework.config.ConfigReader;
import com.cucumber.framework.config.Settings;
import com.cucumber.framework.utilities.ExcelUtil;
import com.cucumber.framework.utilities.LogUtil;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import jxl.read.biff.BiffException;

import java.io.IOException;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize() throws IOException {

        ConfigReader.PopulateSettings();

        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework Initializing...");

//        Settings.DBConnection = DatabaseUtil.Open(Settings.DBConnectionString);
//        DatabaseUtil.ExecuteQuery("select top 1 * from tbl_users", Settings.DBConnection);

        InitializeBrowser(Settings.BrowserType);
        Settings.Logs.Write("Browser Initialized...");

        DriverContext.Browser.GoToUrl(Settings.AUT);
        Settings.Logs.Write("Navigating to " + Settings.AUT);

        try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @After
    public void TearDown(){
        DriverContext.Browser.Close();
    }

}
