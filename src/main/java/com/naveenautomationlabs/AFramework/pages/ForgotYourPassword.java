package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;

public class ForgotYourPassword extends Page {
	public String PAGE_URL = "/opencart/index.php?route=account/forgotten";

	public ForgotYourPassword(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By emailInputField= By.id("input-email");
	private static By continueBtn=By.cssSelector("input[value='Continue']");

	public void enterEmail() {
		((ProxyDriver) wd).sendKeys(emailInputField,"tony@gmail.com");
	}

	public AccountLogin clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new AccountLogin(wd, true);
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}
}
