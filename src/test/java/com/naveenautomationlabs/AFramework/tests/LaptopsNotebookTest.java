package com.naveenautomationlabs.AFramework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;
import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.pages.LaptopsNotebook;
import com.naveenautomationlabs.AFramework.pages.YourStore;

public class LaptopsNotebookTest extends TestBase{
	private YourStore yourStore;
	private LaptopsNotebook laptopsNotebook;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore(wd,true).get();
	}

	@Test 
	public void validateClickingOnListOfLaptopsNotebookGoTORespectivePage() {
		laptopsNotebook = yourStore.mouseHoverLaptopsNotebookLink();
		String nameOfProduct = "MacBook";
		laptopsNotebook.checkClickOnProductOfLaptopsNotebookGoRespectivePage(nameOfProduct);
		Assert.assertEquals(((ProxyDriver) wd).getTitle(), nameOfProduct);
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}


}
