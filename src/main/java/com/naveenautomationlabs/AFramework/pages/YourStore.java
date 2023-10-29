package com.naveenautomationlabs.AFramework.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;
import com.naveenautomationlabs.AFramework.utils.Utils;


public class YourStore extends Page{
	public String PAGE_URL = "/opencart/index.php?route=common/home";

	public YourStore(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By myAccountBtn=By.cssSelector("ul.list-inline>li:nth-of-type(2) a");
	private static By loginBtn=By.cssSelector("ul.dropdown-menu li:nth-of-type(2) a");
	private static By laptopNotebookLink=By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(2)");
	private static By showAllLaptopsNotebookLink=By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(2) div.dropdown-menu>a");
	private List<WebElement> listOfDisplayItemOnMainPage=((ProxyDriver)wd).findElements(By.cssSelector("div.caption a"));
	private List<WebElement> displayMovingOnFooter=((ProxyDriver)wd).findElements(By.cssSelector("div#carousel0>div:nth-of-type(1) >div"));

	private static By displayMacBookOnMain=By.cssSelector("div#slideshow0 div div");
	private static By wishListBtn=By.cssSelector("a#wishlist-total span");
	private static By wishBtn=By.xpath("( //i[@class='fa fa-heart'])[2]");

	public YourStore clickMyAccountBtn() {
		((ProxyDriver) wd).click(myAccountBtn);
		return new YourStore(wd,true);
	}

	public AccountLogin clickLoginBtn() {
		((ProxyDriver) wd).click(loginBtn);
		return new AccountLogin(wd,true);
	}

	public LaptopsNotebook mouseHoverLaptopsNotebookLink() {
		Actions action = new Actions(wd);
		action.moveToElement(((ProxyDriver) wd).findElement(laptopNotebookLink)).perform();
		action.moveToElement(((ProxyDriver) wd).findElement(showAllLaptopsNotebookLink)).perform();
		action.click().perform();
		return new LaptopsNotebook(wd,true);
	}

	public boolean ClickOnDisplayItemOnMainPage() {
		List<Boolean> listOfClick = new ArrayList<Boolean>();
		boolean isClickTakeToRtPage = true;
		for (WebElement element : listOfDisplayItemOnMainPage) {
			String itemName = element.getText();
			if (itemName.equals("Apple Cinema 30\"")) {
				itemName = "Apple Cinema 30";
			}
			if (itemName.equals("Canon EOS 5D")) {
				itemName = "sdf";
			}
			((ProxyDriver) wd).click(element);
			listOfClick.add(wd.getTitle().equals(itemName));
			((ProxyDriver) wd).navigate().back();
		}
		for (boolean b : listOfClick) {
			if (!b) {
				isClickTakeToRtPage = false;
			}
		}
		return isClickTakeToRtPage;
	}

	public boolean checkFooterDisplayImagesMoving() {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for (WebElement element : displayMovingOnFooter) {
			list1.add(element.getAttribute("class"));
		}
		Utils.sleep();
		for (WebElement element : displayMovingOnFooter) {
			list2.add(element.getAttribute("class"));
		}
		boolean isDisplayItemMoving = list1.equals(list2);
		return isDisplayItemMoving;
	}

	public boolean checkDisplayImagesMoving() {

		int point1x = ((ProxyDriver) wd).findElement(displayMacBookOnMain).getLocation().getX();
		int point1y = ((ProxyDriver) wd).findElement(displayMacBookOnMain).getLocation().getY();
		Utils.sleep();
		int point2x = ((ProxyDriver) wd).findElement(displayMacBookOnMain).getLocation().getX();
		int point2y = ((ProxyDriver) wd).findElement(displayMacBookOnMain).getLocation().getY();
		if ((point1x == point2x) && (point1y == point2y)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkWishListUpdated() {
		int currentWishList = Utils.returnDigitsFromString(((ProxyDriver) wd).findElement(wishListBtn).getText());
		//wait.until(ExpectedConditions.visibilityOf(wishBtn));
		((ProxyDriver) wd).click(wishBtn);
		boolean isWishListUpdated = false;
		Utils.sleep();
		int updatedWishList = Utils.returnDigitsFromString(((ProxyDriver) wd).findElement(wishListBtn).getText());
		if (updatedWishList>currentWishList) {
			isWishListUpdated = true;
		}
		return isWishListUpdated;
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
	public YourStore get() {
		return (YourStore) super.get();
	}

}
