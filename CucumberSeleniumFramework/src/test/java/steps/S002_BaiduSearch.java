package steps;

import com.cucumber.framework.base.Base;
import com.cucumber.framework.base.DriverContext;
import pages.P004_BaiduHome;
import cucumber.api.java.en.*;
import org.junit.Assert;


public class S002_BaiduSearch extends Base {

    @Given("^Go to baidu home$")
    public void go_to_baidu_home() throws Throwable {
        DriverContext.Browser.GoToUrl("https://www.baidu.com");
        DriverContext.WaitForPageToLoad();
    }

    @When("^I find baidu logo")
    public void i_find_baidu_logo()throws Throwable {
        CurrentPage = GetInstance(P004_BaiduHome.class);
        Assert.assertTrue("Baidu Logo is not displayed", CurrentPage.As(P004_BaiduHome.class).IsBaiduHomePage());
    }

    @And("^Type the search text \"([^\"]*)\"$")
    public void type_the_search_text(String searchText) throws Throwable {
        CurrentPage.As(P004_BaiduHome.class).enterSearch(searchText);
    }

    @And("^Click the submit$")
    public void click_the_submit() throws Throwable {
        CurrentPage.As(P004_BaiduHome.class).clickSubmit();
        DriverContext.WaitForPageToLoad();
    }

    @Then("^Wait the query result")
    public void wait_the_query_result() throws Throwable {
        Thread.sleep(3000);    //后面可以用显示等待或者隐示等待来优化代码
        Assert.assertEquals("selenium_百度搜索", CurrentPage.As(P004_BaiduHome.class).getPageTitle());
    }
}
