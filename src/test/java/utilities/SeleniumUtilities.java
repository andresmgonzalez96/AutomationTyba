package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtilities extends BaseSeleniumTest {

	public static int WAIT_VALUE = 600;
	private static WebDriverWait wait;

	/**
	 * Method to login.
	 * 
	 * @param webDriver
	 */
	public void login(WebDriver webDriver) {
		driver = webDriver;
		
	}



	/**
	 * Method to Login with user and password.
	 */
	public void login(WebDriver webDriver, String user, String pass) {
		driver = webDriver;
	}

	/**
	 * Method that sleep a specific time.
	 */
	public static void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if an element is visible on the screen.
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean existElement(By id, WebDriver webDriver) {
		driver = webDriver;
		try {
			driver.findElement(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Method to click on the browser back button
	 * 
	 * @return void
	 */
	public void clickToBack() {
		driver.navigate().back();
		SeleniumUtilities.waitTime(2000);
	}

	/**
	 * check if a web element contains a specific css class
	 * 
	 * @param element
	 * @param clase
	 * @return boolean
	 */
	public boolean hasClass(WebElement element, String clase) {
		String classes = element.getAttribute("class");
		for (String c : classes.split(" ")) {
			if (c.equals(clase)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Method to down scroll page.
	 * 
	 * @return void
	 */
	public void downScrollPage(WebDriver webDriver) {
		driver = webDriver;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 450)");
	}
	
	/**
	 * Method to down scroll page.
	 * 
	 * @return void
	 */
	public void upScrollPage(WebDriver webDriver) {
		driver = webDriver;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(50, 450)");
		jse.executeScript("window.scrollBy(0,-1000)");
	}
	
	/**
	 * Method to down scroll page.
	 * 
	 * @return void
	 */
	public void scrollPageByVisibleElement(WebDriver webDriver, WebElement element) {
		driver = webDriver;
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	/**
	 * Method wait until an element to be visible
	 * 
	 * @param element
	 */
	public static void waitLoadElement(By locator, WebDriver driver) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Method wait until an element to be clickeable
	 * 
	 * @param element
	 */
	public static void waitClickeableElement(By locator, WebDriver driver) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * Method wait until all elements to be visible
	 * 
	 * @param element
	 */
	public static void waitLoadElements(By locator, WebDriver driver) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}


}