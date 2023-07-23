package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage{
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver webDriver) {
        driver = webDriver;
    }
    public SearchPage(WebDriver webDriver, String url) {
        this(webDriver);
        driver.get(url);
    }


    private By searchField = By.xpath("//input[@id=\"text\"]");
    private By seachByImg = By.xpath("//input[@id=\"image_search\"]");
    private By searchBtn = By.xpath("//button[@type=\"submit\"]");
    private By clearBtn = By.xpath("//button[contains(@class, 'search3__clear')]");


    public void setRequest(String request) {
        driver.findElement(searchField).sendKeys(request, Keys.TAB);
    }
    public void searchText(String request) {
        driver.findElement(searchField).sendKeys(request, Keys.ENTER);
    }
    public void seachByImg(String imgPath) {
        driver.findElement(seachByImg).sendKeys(imgPath);
    }

    public void submit() {
        driver.findElement(searchBtn).click();
    }

}
