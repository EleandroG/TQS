package com.toptal.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.toptal.webpages.DeveloperApplyPage;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.toptal.com";

    //Locators

    @FindBy( xpath = "//h1")
    WebElement heading;

    //Apply as Developer Button
    @FindBy(linkText = "Apply as a Freelancer")
    private WebElement developerApplyButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        //Assertion
        return heading.getText().toString().contains("Hire Top Talent");
    }

    public void clickOnDeveloperApplyButton(){
        developerApplyButton.click();
    }
}
