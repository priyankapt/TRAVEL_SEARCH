//package com.quinbay.cucumber.steps;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.assertEquals;
//import java.lang.invoke.SwitchPoint;
//import java.sql.SQLOutput;
//public class hotelsearch {
//    WebDriver driver;
//    WebElement subsearch;
//    WebElement outclick;
//
//    @Given("User is on Blibli Travel page")
//    public void userIsOnBlibliTravelPage() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.blibli.com/travel");
//    }
//
//    @When("User Clicks on hotel tab")
//    public void userClicksOnHotelTab() {
//        //WebElement hotel = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[5]/main[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]"));
//        WebElement hotel = driver.findElement(By.xpath("//i[@class='bli-hotel-ic']"));
//        hotel.click();
//
//    }
//
//    @And("User enter hotel name as {string}")
//    public void userEnterHotelNameAs(String arg0) throws InterruptedException {
//        Thread.sleep(3000);
//        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
//        button.click();
//        WebElement location = driver.findElement(By.xpath("//input[@class='input']"));
//        location.click();
//        location.clear();
//        location.sendKeys(arg0);
//        System.out.println("hotel name : " + arg0);
//        WebElement s = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
//        s.click();
//        Thread.sleep(4000);
//        WebElement select = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
//        select.click();
//    }
//
//    @Then("Hotel should be found")
//    public void hotelShouldBeFound() throws InterruptedException {
//        System.out.println("asserted");
//        //assertThat("Hotel tidak ditemukan", equals(notfound.getText()));
//        //WebElement clickfromlist= driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
//        //assertThat(true, is(clickfromlist.isDisplayed()));
//        // boolean notfound=driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]")).isDisplayed();
//        // assertEquals(true,notfound);
//        System.out.println("....");
//        Thread.sleep(5000);
//        driver.close();
//    }
//
//    @And("User enter search name as country name, state name , hotel name")
//    public void userEnterSearchNameAsCountryNameStateNameHotelName() throws InterruptedException {
//        //Thread.sleep(10000);
//        Thread.sleep(3000);
//        WebElement location = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[5]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
//        //WebElement location = driver.findElement(By.xpath("//input[@class='input']"));
//        location.click();
//        Thread.sleep(2000);
//        location.clear();
//        Thread.sleep(2000);
//        location.sendKeys("Bali");
//        //System.out.println("country name : " + arg0);
//        //WebElement bali= driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
//        //bali.click();
//        //Thread.sleep(2000);
//        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
//        button.click();
//        Thread.sleep(2000);
//        WebElement radio = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/ul[1]/li[2]/input[1]"));
//        radio.click();
//        Thread.sleep(35000);
//        WebElement notfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
//        WebElement searchhotelbutton = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
//        WebElement outclick = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]"));
//        String value = notfound.getText();
//        if (value.equals("Hotel tidak ditemukan")) {
//            System.out.println("hotels not found");
//            Thread.sleep(1000);
//            int othercallingways = 1;
//            switch (othercallingways) {
//
//                case 1:
//
//                    System.out.println("SEARCH BY STATE");
//                    Thread.sleep(3000);
//                    recursivefunction();
//                    subsearch.sendKeys("Tamil Nadu");
//                    Thread.sleep(4000);
//                    WebElement clickfromlist = driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
//                    clickfromlist.click();
//                    //assertThat(true, is(clickfromlist.isDisplayed()));
//                    Thread.sleep(4000);
//                    //outclick.click();
//                    Thread.sleep(4000);
//                    searchhotelbutton.click();
//                    Thread.sleep(4000);
//                    WebElement radiochse = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//                    radiochse.click();
//                    Thread.sleep(35000);
//                    hotelnotfound();
//                    Thread.sleep(1000);
//                    break;
//
//
//                case 2:
//
//                    Thread.sleep(1000);
//                    System.out.println("SEARCH BY CITY");
//                    Thread.sleep(1000);
//                    recursivefunction();
//                    subsearch.sendKeys("Bangalore");
//                    Thread.sleep(5000);
//                    WebElement clickfromlist1 = driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
//                    clickfromlist1.click();
//                    Thread.sleep(6000);
//                    searchhotelbutton.click();
//                    Thread.sleep(6000);
//                    WebElement radiochse1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//                    radiochse1.click();
//                    //radiobuttonclick();
//                    Thread.sleep(35000);
//                    hotelnotfound();
//                    System.out.println("SEARCHED BY CITY");
//
//
//                case 3:
//
//
//                    System.out.println("Search by hotel name");
//                    Thread.sleep(4000);
//                    recursivefunction();
//                    subsearch.sendKeys("Zest Hotel Airport Jakarta");
//                    Thread.sleep(4000);
//                    WebElement hotelsearch = driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
//                    hotelsearch.click();
//                    Thread.sleep(4000);
//                    searchhotelbutton.click();
//                    Thread.sleep(4000);
//                    //WebElement bookroom = driver.findElement(By.xpath(("//button[@class='see-room-button']")));
//                    //bookroom.click();
//                    //WebElement add = driver.findElement(By.xpath("//button[@class='room-box-third-section-button']"));
//                    //add.click();
//                    System.out.println("SEARCHED BY HOTEL NAME");
//                    break;
//                case 4:
//                    System.out.println("all cases checked");
//                    Thread.sleep(3000);
//                    recursivefunction();
//                    subsearch.sendKeys("Bali, Indonesia");
//                    Thread.sleep(3000);
//                    outclick.click();
//                    Thread.sleep(2000);
//                    searchhotelbutton.click();
//                    Thread.sleep(30000);
//                    WebElement hotelclick = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[2]/div[1]/a[1]/div[1]/div[2]/span[1]/div[1]"));
//                    hotelclick.click();
//                    Thread.sleep(3000);
//                    WebElement bookroom1 = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
//                    bookroom1.click();
//                    Thread.sleep(4000);
//                    System.out.println("Room selected");
//            }
//        } else {
//            System.out.println("Hotels found");
//        }
//    }
//    public void recursivefunction() throws InterruptedException {
//        subsearch = driver.findElement(By.xpath("//input[@class='search-bar-input']"));
//        subsearch.click();
//        subsearch.clear();
//        Thread.sleep(2000);
//
//    }
//    public void hotelnotfound() {
//        WebElement notfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
//        String value = notfound.getText();
//        if (value.equals("Hotel tidak ditemukan")) {
//            System.out.println("hotels not found for selected filter, try again");
//        }
//    }
//    public void radiobuttonclick() throws InterruptedException {
//        WebElement radio = driver.findElement(By.xpath("//input[@type='checkbox'])[2]"));
//        radio.click();
//        Thread.sleep(5000);
//    }
//}
//
//
