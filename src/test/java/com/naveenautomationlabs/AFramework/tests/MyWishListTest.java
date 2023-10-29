package com.naveenautomationlabs.AFramework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;
import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.pages.AccountLogin;
import com.naveenautomationlabs.AFramework.pages.MyAccount;
import com.naveenautomationlabs.AFramework.pages.MyWishList;
import com.naveenautomationlabs.AFramework.pages.MyWishList.MyWishListTable;
import com.naveenautomationlabs.AFramework.pages.YourStore;

public class MyWishListTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private MyWishList myWishList;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore(wd, true).get();
	}

	@Test(priority = 1)
	public void validateLogin() {
		gettingIntoMyAccountPage();
		// myWishList=myAccount.clickWishListBtn();
		Assert.assertEquals(((ProxyDriver) wd).getTitle(), "My Account");
	}

	@Test
	public void validateGettingCellElementFromTable() {
		gettingIntoMyAccountPage();
		myWishList = myAccount.clickWishListBtn();
		String s = myWishList.getCellElementFromTable(MyWishListTable.PRODUCT_NAME, "Product 15").getText();
		System.out.println(s);
		Assert.assertEquals(s, "Apple Cinema 30\"");
	}

	/*
	 * @Test public void validateRtNavigationClick() { gettingIntoMyAccountPage();
	 * String s = myAccount.rtNavigationBar(RtNavigation.WISH_LIST);
	 * Assert.assertEquals(((ProxyDriver) wd).getTitle(), s); }
	 */
	public void gettingIntoMyAccountPage() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("tony@gmail.com", "Password2");

	}

}
