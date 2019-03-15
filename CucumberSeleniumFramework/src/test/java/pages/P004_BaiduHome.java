package pages;

import com.cucumber.framework.base.BasePage;
import com.cucumber.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class P004_BaiduHome extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='lg']/img")
    public WebElement ImageBaiduLogo;

    @FindBy(how = How.ID, using = "kw")
    public WebElement InputBaiduTextBox;

    @FindBy(how = How.ID, using = "su")
    public WebElement btn_submit;

    //获取当前页面标题
    public String getPageTitle(){
        return DriverContext.Driver.getTitle();
    }

    // 输入查询内容，并点击查询按钮
    public void enterSearch(String searchText){
        InputBaiduTextBox.clear();
        InputBaiduTextBox.sendKeys(searchText);
        //btn_submit.click();
    }

    // 输入查询内容，并点击查询按钮
    public void clickSubmit(){
        btn_submit.click();
    }

    public boolean IsBaiduHomePage(){
        return ImageBaiduLogo.isDisplayed();
    }

}