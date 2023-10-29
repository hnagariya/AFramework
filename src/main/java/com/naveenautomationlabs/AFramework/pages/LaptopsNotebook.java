package com.naveenautomationlabs.AFramework.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;


public class LaptopsNotebook extends Page {
	public String PAGE_URL = "/opencart/index.php?route=product/category&path=18";

	public LaptopsNotebook(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private List<WebElement> listOfLaptopsNotebook=((ProxyDriver)wd).findElements(By.cssSelector("div.product-thumb div.caption a"));

	public void checkClickOnProductOfLaptopsNotebookGoRespectivePage(String nameOfProduct) {
		for (WebElement element : listOfLaptopsNotebook) {
			if ((element.getText()).equals(nameOfProduct)) {
				//wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
		}
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public LaptopsNotebook get() {
		return (LaptopsNotebook) super.get();
	}

}
