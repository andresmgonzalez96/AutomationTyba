package shopping;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class CarritoDeComprasPage {

	private WebDriver driver;
	
	private By tablaItemsLocator;
	
	private By nameItemLocator;	
	private By colorItemLocator;
	private By cantidadItemLocator;
	private By priceItemLocator;
	
	private By checkoutButtonLocator;
	
	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public CarritoDeComprasPage(WebDriver driver) {
		this.driver = driver;
		tablaItemsLocator = By.className("fixedTableEdgeCompatibility");
		
		nameItemLocator = By.className("productName");
		colorItemLocator = By.className("productColor");						
		cantidadItemLocator = By.cssSelector("#shoppingCart > table > tbody > tr > td:nth-child(5) > label.ng-binding");
		priceItemLocator = By.className("price");
		
		checkoutButtonLocator = By.id("checkOutButton");
		
		wait = new WebDriverWait(driver, 60);

	}

	/**
	 * Method wait until an element to be visible
	 * 
	 * @param element
	 */
	public void waitLoadElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Method wait until all elements to be visible
	 * 
	 * @param element
	 */
	public void waitLoadElements(By locator) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * Metodo que devuelve el nombre de un item del carrito
	 */
	public String getNameItem() {
		waitLoadElement(nameItemLocator);
		return driver.findElement(nameItemLocator).getText();
	}
	
	/**
	 * Metodo que devuelve el color del item del carrito
	 */
	public String getColorItem() {
		waitLoadElement(colorItemLocator);
		return driver.findElement(colorItemLocator).getAttribute("title");
	}
	
	/**
	 * Metodo que devuelve la cantidad del item a comprar en el carrito
	 */
	public String getQuantyItem() {
		waitLoadElement(cantidadItemLocator);
		return driver.findElement(cantidadItemLocator).getText();
	}

	/**
	 * Metodo que devuelve el precio del item a comprar en el carrito
	 */
	public String getPriceItem() {
		waitLoadElement(priceItemLocator);
		return driver.findElements(priceItemLocator).get(1).getText();
	}
	

}
