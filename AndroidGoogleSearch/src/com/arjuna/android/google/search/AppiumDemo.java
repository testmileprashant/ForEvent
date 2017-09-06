package com.arjuna.android.google.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import unitee.annotations.TestClass;
import unitee.annotations.TestMethod;

@TestClass
public class AppiumDemo {
	

	@TestMethod
	public void sampleTest() throws InterruptedException {
		System.out.println("Execution started!!");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY223Z7DZG");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(cap);
		driver.get("https://www.google.co.in");
		WebElement searchField = driver.findElement(By.cssSelector("input[name='q']"));
		searchField.sendKeys("Test Mile");
		searchField.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		List<WebElement> searchButtonList = driver.findElements(By.xpath("//button[@aria-label = 'Google Search']/div"));
		System.out.println(searchButtonList.size());
		for (WebElement webElement : searchButtonList) {
			if (webElement.isDisplayed()) {
				webElement.click();
				break;
			}
		}
		List<WebElement> searchResult = driver.findElements(By.cssSelector("div[class = 'srg']>div>div>div>div>div>div>h3>a"));
		WebElement firstSearch = searchResult.get(0);
		String linkTitle = firstSearch.getAttribute("text");
		System.out.println(linkTitle);
		firstSearch.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if (linkTitle.equals(pageTitle)) {
			System.out.println("Both titles are equal");
		} else {
			System.out.println("Both titles are not equal");
		}

		System.out.println("Execution completed!!");

	}
}
