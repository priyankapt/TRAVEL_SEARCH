package com.quinbay.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    WebDriver driver;
    @FindBy(xpath="//input[@type='search']")

    WebElement searchBox;
    public void setSearchText(String item) {
        searchBox.sendKeys(item);
    }



}
