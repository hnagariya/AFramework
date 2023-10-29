package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;

public class AccountLogin extends Page {
	public String PAGE_URL = "/opencart/index.php?route=account/login";

	public AccountLogin(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By emailInputField = By.id("input-email");
	private static By passwordInputField = By.id("input-password");
	private static By loginBtn = By.cssSelector("input[value='Login']");
	private static By forgotPasswordLink = By.cssSelector("div.form-group a");
	private static By passwordResetLinkText = By.cssSelector("div.alert");

	private void enterEmail(String userName) {
		((ProxyDriver) wd).sendKeys(emailInputField, userName);
	}

	private void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInputField, password);
	}

	private MyAccount clickLoginBtn() {
		((ProxyDriver) wd).click(loginBtn);
		return new MyAccount(wd,true);
	}

	public MyAccount loginToPortal(String userName, String password) {
		enterEmail(userName);
		enterPassword(password);
		return clickLoginBtn();
	}

	public ForgotYourPassword clickForgotPassword() {
		((ProxyDriver) wd).click(forgotPasswordLink);
		return new ForgotYourPassword(wd, true);
	}

	public String getPasswordResetLinkSuccessMessageText() {
		return ((ProxyDriver) wd).getText(passwordResetLinkText);
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
	public AccountLogin get() {
		return (AccountLogin) super.get();
	}

}
