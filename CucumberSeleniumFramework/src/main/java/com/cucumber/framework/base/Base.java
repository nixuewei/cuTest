package com.cucumber.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    protected static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
        Object obj = PageFactory.initElements(DriverContext.Driver, page);
        return page.cast(obj);
    }

}
