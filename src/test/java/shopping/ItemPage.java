package shopping;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class ItemPage {

	private WebDriver driver;
	
	private By descriptionSectionLocator;
	private By nameItemLocator;
	private By priceItemLocator;	
	private By colorItemLocator;
	private By cantidadItemLocator;
	private By addToCarButtonLocator;

	private By popularNameItem0Locator;

	
	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public ItemPage(WebDriver driver) {
		this.driver = driver;
			
		descriptionSectionLocator = By.id("Description");
		
		nameItemLocator = By.className("roboto-regular");
		priceItemLocator = By.className("roboto-thin");		
		colorItemLocator = By.id("rabbit");
		addToCarButtonLocator = By.name("save_to_cart");
		cantidadItemLocator = By.name("quantity");
		
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
	 * Metodo que devuelve el nombre de un item
	 */
	public String getNameItem() {
		waitLoadElement(descriptionSectionLocator);
		return driver.findElement(descriptionSectionLocator).findElement(nameItemLocator).getText();
	}

	/**
	 * Metodo que devuelve el nombre de un item
	 */
	public String getPriceItem() {
		waitLoadElement(descriptionSectionLocator);
		return driver.findElement(descriptionSectionLocator).findElement(priceItemLocator).getText();
	}
	
	/**
	 * Metodo ingresa la cantidad a comprar de un item
	 */
	public void setQuantityItem(String quantity) {
		waitLoadElement(descriptionSectionLocator);
		driver.findElement(descriptionSectionLocator).findElement(cantidadItemLocator).click();
		driver.findElement(descriptionSectionLocator).findElement(cantidadItemLocator).sendKeys(quantity);
	}
	
	/**
	 * Metodo ingresa la cantidad a comprar de un item
	 */
	public void setColorItem(String color) {
		waitLoadElements(colorItemLocator);
		List<WebElement> colors = driver.findElements(colorItemLocator);
		if (colors.size() > 1) {
			for (int i = 0; i < colors.size(); i++) {
				if (color.equals(colors.get(i).getAttribute("title"))) {
					colors.get(i).click();
					break;
				}
			}
		} else {
			colors.get(0).click();
		}			
	}
	
	/**
	 * Metodo que devuelve el nombre de un item
	 */
	public void clicAddToCar() {
		waitLoadElement(addToCarButtonLocator);
		driver.findElement(addToCarButtonLocator).click();
	}
	

}
