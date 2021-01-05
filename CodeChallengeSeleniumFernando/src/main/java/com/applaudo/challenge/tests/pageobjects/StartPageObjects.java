package com.applaudo.challenge.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPageObjects {
    public WebDriver myDriver;

    public StartPageObjects(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    //Variable to find an element from the list
    private final By selectorForCartItem = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]");

    //Variable to find the search input
    private final By selectorForSearchInput = By.id("search_query_top");

    //Variable to find the search button
    private final By selectorForSearchButton = By.name("submit_search");

    //Variable to find the result text from the search
    private final By selectorForResultText = By.xpath("//span[contains(text(),'been found.')]");



    // ================================================== LOCATE OBJECT SECTION =============================================================

    /*
     * METHOD: getFirstItemInCart
     * AUTHOR: Fernando Maldonado
     * CREATED: 29/DIC/2020- Fernando Maldonado
     * UPDATED: 29/DIC/2020- Fernando Maldonado
     */
    public WebElement getFirstItemInCart() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForCartItem));
    }

    /*
     * METHOD: getSearchInput
     * AUTHOR: Fernando Maldonado
     * CREATED: 05/JAN/2021- Fernando Maldonado
     * UPDATED: 05/JAN/2021- Fernando Maldonado
     */
    public WebElement getSearchInput() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForSearchInput));
    }

    /*
     * METHOD: getSearchButton
     * AUTHOR: Fernando Maldonado
     * CREATED: 05/JAN/2021- Fernando Maldonado
     * UPDATED: 05/JAN/2021- Fernando Maldonado
     */
    public WebElement getSearchButton() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForSearchButton));
    }

    /*
     * METHOD: getSearchButton
     * AUTHOR: Fernando Maldonado
     * CREATED: 05/JAN/2021- Fernando Maldonado
     * UPDATED: 05/JAN/2021- Fernando Maldonado
     */
    public WebElement getResultText() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForResultText));
    }
}
