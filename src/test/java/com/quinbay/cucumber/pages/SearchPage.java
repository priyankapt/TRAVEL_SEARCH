package com.quinbay.cucumber.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver webDriver){
        driver=webDriver;
    }

    @FindBy(xpath="//button[contains(text(),'Cari Hotel')]")
    WebElement button;

    @FindBy(xpath = "//input[@class='input']")
    WebElement location;

    @FindBy(xpath="//button[contains(text(),'Cari Hotel')]")
    WebElement select;

    @FindBy(xpath="//div[contains(text(),'Hotel tidak ditemukan')]")
    WebElement notfound;

    @FindBy(xpath="//button[contains(text(),'Cari Hotel')]")
    WebElement searchhotelbutton;

    @FindBy(xpath="//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]")
    WebElement outclick;

    @FindBy(xpath="(//li[@class='autocomplete__result-item'])[1]/div/div/div")
    WebElement clickfromlist;

    @FindBy(xpath=("//input[@type='checkbox'])[2]"))
    WebElement radiochse;

    @FindBy(xpath="//input[@id='billing_postcode']")
    WebElement zip;
    @FindBy(xpath="//input[@id='billing_phone']")
    WebElement phone;
    @FindBy(xpath="//input[@id='billing_email']")
    WebElement email;
    @FindBy(xpath="//button[@id='place_order']")
    WebElement Place_order;

    public void setSelect()
    {
        select.click();
    }

    public void setLocation(String item) {
        location.click();
    }

    public void setButton() {
        button.click();
    }

    public void setNotfound()
    {
        notfound.click();
    }

    public void setSearchhotelbutton()
    {
        searchhotelbutton.click();
    }

    public void setOutclick (){
        outclick.click();
    }

    public void setClickfromlist (){
        clickfromlist.click();
    }

    public void setRadiochse()
    {
        radiochse.click();
    }


}

