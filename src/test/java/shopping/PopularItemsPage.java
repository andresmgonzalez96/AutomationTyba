package shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class PopularItemsPage {

	private WebDriver driver;
	private By optionsMenuLocator;
	
	private By namePopularItemsLocator;
	
	private By popularDetailsItem0Locator;
	private By popularDetailsItem1Locator;
	private By popularDetailsItem2Locator;
	private By popularNameItem0Locator;
	
	private By nuestrosProductosLocator;
	
	private By iconBuyCarLocator;

	
	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public PopularItemsPage(WebDriver driver) {
		this.driver = driver;
		optionsMenuLocator = By.className("nav-li-Links");
		
		namePopularItemsLocator = By.id("popular_items");
		
		popularDetailsItem0Locator = By.id("details_16");
		popularDetailsItem1Locator = By.id("details_10");
		popularDetailsItem2Locator = By.id("details_21");			
		popularNameItem0Locator = By.name("popular_item_16_name");
		
		nuestrosProductosLocator = By.id("our_products");
		
		iconBuyCarLocator = By.id("shoppingCartLink");
		
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
	 * Method wait until an element to be clickeable
	 * 
	 * @param element
	 */
	public void waitClickeableElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
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
	 * Metodo que hace clic en la opcion de popular Items.
	 */
	public void clicPopularItems() {
		waitClickeableElement(nuestrosProductosLocator);
		waitLoadElements(optionsMenuLocator);
		driver.findElements(optionsMenuLocator).get(1).click();
		SeleniumUtilities.waitTime(3000);
	}

	/**
	 * Metodo que hace clic en el detalle del primer item popular
	 */
	public void clicDetallesPrimerItem() {
		waitClickeableElement(popularDetailsItem0Locator);
		waitLoadElement(popularDetailsItem0Locator);
		driver.findElement(popularDetailsItem0Locator).click();
	}
	
	/**
	 * Metodo que hace clic en el detalle del Segundo item popular
	 */
	public void clicDetallesSegundoItem() {
		waitLoadElement(popularDetailsItem1Locator);
		driver.findElement(popularDetailsItem1Locator).click();
	}
	
	/**
	 * Metodo que hace clic en el detalle del Tercer item popular
	 */
	public void clicDetallesTercerItem() {
		waitLoadElement(popularDetailsItem2Locator);
		driver.findElement(popularDetailsItem2Locator).click();
	}
	
	/**
	 * Metodo que devuelve el nombre del primer item popular
	 */
	public String getNamePrimerPopularItem() {
		waitLoadElement(namePopularItemsLocator);
		waitClickeableElement(popularDetailsItem0Locator);
		return driver.findElement(popularNameItem0Locator).getText();
	}
	
	/**
	 * Metodo que abre el carrito de compras
	 */
	public void irAlCarritoButton() {
		waitLoadElement(iconBuyCarLocator);
		driver.findElement(iconBuyCarLocator).click();
	}
	

}
