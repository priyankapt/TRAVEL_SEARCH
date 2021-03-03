package com.quinbay.cucumber.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebElement button1 = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        WebElement outclick = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]"));
        String value = notfound.getText();
        if (value.equals("Hotel tidak ditemukan")) {
            System.out.println("hotels not found");
            recursivefunction();
            int othercallingways = 1;
            switch (othercallingways) {
                case 1:
                    System.out.println("SEARCH BY STATE");
                    subsearch.sendKeys("Tamil Nadu, India");
                    Thread.sleep(1000);
                    //WebElement outclick= driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]"));
                    outclick.click();
                    Thread.sleep(3000);
                    button1.click();
                    Thread.sleep(3000);
                    System.out.println("SEARCHED BY STATE");
                case 2:
                    System.out.println("SEARCH BY CITY");
                    recursivefunction();
                    subsearch.sendKeys("Bangalore");
                    Thread.sleep(1000);
                    outclick.click();
                    Thread.sleep(3000);
                    button1.click();
                    Thread.sleep(3000);
                    System.out.println("SEARCHED BY CITY");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
            }

        } else {
            System.out.println("Hotels found");
        }
        //othersearch();
    }

    public void recursivefunction() {

        subsearch = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        subsearch.click();
        subsearch.clear();
    }
}
//    public void othersearch() throws InterruptedException {
//        subsearch.sendKeys("Tamil Nadu, India");
//        Thread.sleep(1000);
//        WebElement outclick= driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]"));
//        outclick.click();
//        Thread.sleep(3000);
//        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
//        button.click();
//        System.out.println("button clicked");
//    }

//    @And("I enter state name as {string}")
//    public void iEnterStateNameAs(String arg0) {
//
//
//    }
//
//    @And("User enter city name as {string}")
//    public void iEnterCityNameAs(String arg0) {
//
//    }
//
//    @And("User enter location name as {string}")
//    public void iEnterLocationNameAs(String arg0) {
//    }
//
//}
