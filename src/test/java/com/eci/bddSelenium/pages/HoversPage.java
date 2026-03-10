package com.eci.bddSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage {

    WebDriver driver;

    @FindBy(xpath = "(//div[@class='figure'])[1]")
    WebElement firstUser;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[1]")
    WebElement firstUsername;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverFirstUser() {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstUser).perform();
    }

    public String getFirstUsername() {
        return firstUsername.getText();
    }
}
