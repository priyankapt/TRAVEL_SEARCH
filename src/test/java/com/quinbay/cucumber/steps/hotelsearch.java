package com.quinbay.cucumber.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.lang.invoke.SwitchPoint;
import java.sql.SQLOutput;
public class hotelsearch {
    WebDriver driver;
    WebElement subsearch;
    WebElement button1;
    WebElement outclick;


    @Given("User is on Blibli Travel page")
    public void userIsOnBlibliTravelPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
    }

    @When("User Clicks on hotel tab")
    public void userClicksOnHotelTab() {
        WebElement hotel = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[5]/main[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]"));
        hotel.click();
    }

    @And("User enter hotel name as {string}")
    public void userEnterHotelNameAs(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        button.click();
        WebElement location = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        location.click();
        location.clear();
        location.sendKeys(arg0);
        System.out.println("hotel name : " + arg0);
        WebElement s = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        s.click();
        Thread.sleep(4000);
        WebElement sel = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        sel.click();
    }

    @Then("Hotel should be found")
    public void hotelShouldBeFound() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]")).isSelected());
        System.out.println("asserted");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]")).isEnabled());
        System.out.println("....");
        Thread.sleep(5000);
       driver.close();

    }


    @And("User enter country name as {string}")
    public void userEnterCountryNameAs(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        WebElement location = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[5]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        location.click();
        location.clear();
        location.sendKeys(arg0);
        System.out.println("country name : " + arg0);
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        button.click();
        Thread.sleep(3000);
        WebElement radio = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/ul[1]/li[2]/input[1]"));
        radio.click();
        Thread.sleep(35000);
        WebElement notfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
        WebElement searchhotelbutton = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        WebElement outclick = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]"));
        String value = notfound.getText();
        if (value.equals("Hotel tidak ditemukan")) {
            System.out.println("hotels not found");
            Thread.sleep(1000);
           // recursivefunction();
            int othercallingways = 4;
            switch (othercallingways) {
                case 1:
                    System.out.println("SEARCH BY STATE");
                    Thread.sleep(1000);
                    recursivefunction();
                    subsearch.sendKeys("Tamil Nadu, India");
                    Thread.sleep(2000);
                    outclick.click();
                    Thread.sleep(3000);
                    searchhotelbutton.click();
                    Thread.sleep(3000);
                    radiobuttonclick();
                    Thread.sleep(35000);
                    hotelnotfound();

                case 2:
                    Thread.sleep(10000);
                    System.out.println("SEARCH BY CITY");
                    Thread.sleep(1000);
                    recursivefunction();
                    subsearch.sendKeys("Bangalore, Karnataka, India");
                    Thread.sleep(2000);
                    outclick.click();
                    //Thread.sleep(3000);
                    searchhotelbutton.click();
                    Thread.sleep(3000);
                    radiobuttonclick();
                    Thread.sleep(35000);
                    hotelnotfound();
                    System.out.println("SEARCHED BY CITY");
                    //Thread.sleep(20000);
                case 3:
                    System.out.println("Search by hotel name");
                    recursivefunction();
                    subsearch.sendKeys("Zest Hotel Airport Jakarta, Benda, Kota Tangerang, Banten, Indonesia");
                    Thread.sleep(2000);
                    outclick.click();
                    Thread.sleep(3000);
                    searchhotelbutton.click();
                    Thread.sleep(3000);
                    radiobuttonclick();
                    Thread.sleep(35000);
                    hotelnotfound();
                    System.out.println("SEARCHED BY HOTEL NAME");
                    Thread.sleep(20000);
                case 4:
                    System.out.println("all cases checked");
                    Thread.sleep(3000);
                    recursivefunction();
                    Thread.sleep(3000);
                    subsearch.sendKeys("Bali, Indonesia");
                    Thread.sleep(2000);
                    outclick.click();
                    Thread.sleep(3000);
                    searchhotelbutton.click();
                    Thread.sleep(3000);
                    WebElement hotelclick= driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[2]/div[1]/a[1]/div[1]/div[2]/span[1]/div[1]"));
                    hotelclick.click();
                    Thread.sleep(3000);
                    WebElement bookroom = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
                    bookroom.click();
                    System.out.println("Room selected");
                    break;
            }
        }
        else {
            System.out.println("Hotels found");
        }
    }
    public void hotelnotfound() {
        WebElement notfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
        String value = notfound.getText();
        if (value.equals("Hotel tidak ditemukan")) {
            System.out.println("hotels not found for selected filter, try again");
        }
    }
    public void radiobuttonclick() throws InterruptedException {
        Thread.sleep(3000);
        WebElement radio = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/ul[1]/li[2]/input[1]"));
        radio.click();
        Thread.sleep(3000);
    }
    public void recursivefunction() {
        subsearch = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        subsearch.click();
        subsearch.clear();

    }
}