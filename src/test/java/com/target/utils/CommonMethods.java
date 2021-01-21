package com.target.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.target.testbase.BaseClass;

public class CommonMethods extends BaseClass {

	/**
	 * Method that clears and sends Keys
	 * 
	 * @param element
	 * @param Text
	 */

	public static void sentText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This Method will checks if Radio/checkbox is enabled and clicks it
	 * 
	 * @param redioOrChekbox
	 * @param value
	 */

	public static void clickRadioOrCheckbox(List<WebElement> redioOrchekbox, String value) {

		String actualValue;
		for (WebElement el : redioOrchekbox) { // Will take every element and click right the way

			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	/**
	 * This Method will checks if text is there then selects it
	 * 
	 * @param element
	 * @param textToSelect
	 */

	public static void selectDDValue(WebElement element, String textToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that selects value by index
	 * 
	 * @param element
	 * @param index
	 */

	public static void selectDdValue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method Will Accept Alert and catches exception if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Will Dismiss Alert and Catches exception if Alert is not present
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Will gets text of Alert and catches exception if alert is not
	 * present
	 */

	public static String getAlertText() {
		String alertText = null;
		try {

			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	/**
	 * This Method will sends text of Alert and catches exception if alert is not
	 * present
	 */

	public static void sendAlertText(String Text) {
		try {

			Alert alert = driver.switchTo().alert();
			alert.sendKeys(Text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Will Switch the focus to the Frame by Name or ID
	 */

	public static void switchToFrameByNameorId(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Will Switch the focus to the Frame by element
	 */

	public static void switchToFrameByElement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method will switch the focus to the Frame by Index
	 */
	public static void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method will switches to child window
	 */
	public static void SwitchToChildWindows() {

		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	/**
	 * This Method will wait for the Clickablety of the element
	 */

	public static void WaitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This Method will wait for the visibility of the element
	 */

	public static WebElement waitForVisibilty(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method will click on the element
	 */
	public static void click(WebElement element) {
		WaitForClickability(element);
		element.click();
	}

	/**
	 * This Method will get the JavaScript Executor
	 */
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
		
	}

	/**
	 * This method will click using Java Script
	 */

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("argument[0].click", element);
	}

	/**
	 * This Method Will Scroll To An Element
	 */

	public static void scrollToElement(WebElement element) {

		getJSObject().executeScript("argument[0].scrollintoView(true);", element);
	}

	/**
	 * This Method will Scroll Down Using JS
	 */

	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method That will scroll up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */

	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This Method will Wait
	 */
	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will take A screen Shot
	 * 
	 * @param filename
	 * @return
	 */
	public static byte[] takeScreenShot(String filename) {
		TakesScreenshot tS = (TakesScreenshot) driver;
		byte[] picBytes = tS.getScreenshotAs(OutputType.BYTES);
		
		File file= tS.getScreenshotAs(OutputType.FILE);
		String DestinationFile = Constants.SCHEENSHOT_FILEPATH + filename + getTimeStamp()+ ".png";
		try {
			FileUtils.copyFile(file, new File(DestinationFile));
		} catch (Exception e) {
			System.out.println("Can not take Screenshot");
		}
		return picBytes;
	}

	public static String getTimeStamp() {
		Date date = new Date();
		System.out.println(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
		//return sdf.format(sdf.format(date.getTime()));
	}
	
	
	
	public static Actions getAction() {
		Actions action = new Actions(driver);
		return action;
	}
	
	
	
	public static void moveToElemenbt(WebElement element) {
		getAction().moveToElement(element).perform();
	}
	
	
	
	public static void dragDrop(WebElement drag, WebElement drop) {
		getAction().dragAndDrop(drag, drop).perform();
	}
	
}
