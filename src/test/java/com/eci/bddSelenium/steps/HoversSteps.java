package com.eci.bddSelenium.steps;

import com.eci.bddSelenium.pages.HoversPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class HoversSteps {

    WebDriver driver;
    HoversPage hoversPage;

    @Given("I am on the hovers page")
    public void i_am_on_the_hovers_page() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/hovers");

        hoversPage = new HoversPage(driver);
    }

    @When("I hover over the first user")
    public void i_hover_over_the_first_user() {
        hoversPage.hoverFirstUser();
    }

    @Then("the username {string} should be visible")
    public void the_username_should_be_visible(String username) {

        String text = hoversPage.getFirstUsername();
        assertTrue(text.contains(username));

        driver.quit();
    }
}