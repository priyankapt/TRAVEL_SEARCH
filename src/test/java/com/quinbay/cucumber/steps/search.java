package com.quinbay.cucumber.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class search {
    WebDriver driver;
    WebElement subsearch;
    static int count = 0;
    String state[] = {"Tamil Nadu", "Andhra", "Karnataka"};
    String name[]={"hotel d batur","Radisson Lampung Kedaton","Zest Hotel Airport Jakarta"};

    @Given("User is on Blibli Travel page")

    public void userIsOnBlibliTravelPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
    }

    @When("User Clicks on hotel tab")
    public void userClicksOnHotelTab() {
        WebElement hotel = driver.findElement(By.xpath("//i[@class='bli-hotel-ic']"));
        hotel.click();

    }

    @And("User enter search name as country name, state name , hotel name")
    public void userEnterSearchNameAsCountryNameStateNameHotelName() throws InterruptedException {
        Thread.sleep(3000);
        WebElement location = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[5]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        location.click();
        Thread.sleep(2000);
        location.clear();
        Thread.sleep(2000);
        location.sendKeys("Bali");
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        button.click();
        Thread.sleep(2000);
        WebElement radio = driver.findElement(By.xpath("//body/div[@id='travel-blibli-app']/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/ul[1]/li[2]/input[1]"));
        radio.click();
        Thread.sleep(35000);
        WebElement notfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
        String value = notfound.getText();
        if (value.equals("Hotel tidak ditemukan")||value.equals("Kamar Tidak Tersedia")) {
            System.out.println("hotels/rooms not found");
            Thread.sleep(1000);
            //hotels();
            rooms();
        }
    }
    public void hotels() throws InterruptedException {
        if (count == 3 || hotelnotfound()) {
            return;
        }
        subsearch = driver.findElement(By.xpath("//input[@class='search-bar-input']"));
        subsearch.click();
        subsearch.clear();
        subsearch.sendKeys(state[search.count]);
        Thread.sleep(3000);
        WebElement clickfromlist = driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
        clickfromlist.click();
        Thread.sleep(4000);
        WebElement searchhotelbutton = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        searchhotelbutton.click();
        Thread.sleep(8000);
        WebElement radiochse = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(8000);
        radiochse.click();
        Thread.sleep(35000);
        search.count++;
        hotels();
    }
    public void rooms() throws InterruptedException {
        if (count == 3 || roomnotfound()) {
            return;
        }
        subsearch = driver.findElement(By.xpath("//input[@class='search-bar-input']"));
        subsearch.click();
        subsearch.clear();
        subsearch.sendKeys(name[search.count]);
        Thread.sleep(3000);
        WebElement clickfromlist = driver.findElement(By.xpath("(//li[@class='autocomplete__result-item'])[1]/div/div/div"));
        clickfromlist.click();
        Thread.sleep(4000);
        WebElement searchhotelbutton = driver.findElement(By.xpath("//button[contains(text(),'Cari Hotel')]"));
        searchhotelbutton.click();

        Thread.sleep(8000);
        search.count++;
        rooms();
    }

    public boolean hotelnotfound() {
        WebElement hotelnotfound = driver.findElement(By.xpath("//div[contains(text(),'Hotel tidak ditemukan')]"));
        String value = hotelnotfound.getText();
        if (value.equals("Hotel tidak ditemukan")) {
            System.out.println("hotels not found for selected filter, try again");
            return false;
        }
        return true;
    }

    public boolean roomnotfound() {
        WebElement roomnotfound = driver.findElement(By.xpath("//div[contains(text(),'Kamar Tidak Tersedia')]"));
        String value1 = roomnotfound.getText();
        if (value1.equals("Kamar Tidak Tersedia")) {
            System.out.println("Rooms not found for selected filter, try again");
            return false;
        }
        return true;
    }


    @Then("Hotel should be found")
    public void hotelShouldBeFound() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}



