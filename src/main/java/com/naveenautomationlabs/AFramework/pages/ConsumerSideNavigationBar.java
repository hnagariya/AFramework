package com.naveenautomationlabs.AFramework.pages;

public enum ConsumerSideNavigationBar {
	EDIT_ACCOUNT("Account Login",AccountLogin.class), 
	MY_ACCOUNT("My Account",MyAccount.class);

	private Class<? extends Page> _pageClass;
	private String item;

	ConsumerSideNavigationBar(String item,Class<? extends Page> pageClass) {
		this._pageClass = pageClass;
		this.item=item;
	}

	public Class<? extends Page> getpageClass() {
		return _pageClass;
	}
	
	

	public String getItem() {
		return item;
	}

	public static ConsumerSideNavigationBar getItemByText(String text) {
		ConsumerSideNavigationBar[] all = ConsumerSideNavigationBar.values();
		for (int i = 0; i < all.length; i++) {
			if (all[i].name().toLowerCase().equalsIgnoreCase(text)) {
				return all[i];
			}
		}
		return null;
	}


}
