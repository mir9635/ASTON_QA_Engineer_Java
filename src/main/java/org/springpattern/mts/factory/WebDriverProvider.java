package org.springpattern.mts.factory;


import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {
    WebDriver createDriver();
}
