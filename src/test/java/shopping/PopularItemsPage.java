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

	}

	

	/**
	 * Metodo que hace clic en la opcion de popular Items.
	 */
	public void clicPopularItems() {
		SeleniumUtilities.waitClickeableElement(nuestrosProductosLocator, driver);
		SeleniumUtilities.waitLoadElements(optionsMenuLocator, driver);
		driver.findElements(optionsMenuLocator).get(1).click();
		SeleniumUtilities.waitTime(3000);
	}

	/**
	 * Metodo que hace clic en el detalle del primer item popular
	 */
	public void clicDetallesPrimerItem() {
		SeleniumUtilities.waitClickeableElement(popularDetailsItem0Locator, driver);
		SeleniumUtilities.waitLoadElement(popularDetailsItem0Locator, driver);
		driver.findElement(popularDetailsItem0Locator).click();
	}
	
	/**
	 * Metodo que hace clic en el detalle del Segundo item popular
	 */
	public void clicDetallesSegundoItem() {
		SeleniumUtilities.waitLoadElement(popularDetailsItem1Locator, driver);
		driver.findElement(popularDetailsItem1Locator).click();
	}
	
	/**
	 * Metodo que hace clic en el detalle del Tercer item popular
	 */
	public void clicDetallesTercerItem() {
		SeleniumUtilities.waitLoadElement(popularDetailsItem2Locator, driver);
		driver.findElement(popularDetailsItem2Locator).click();
	}
	
	/**
	 * Metodo que devuelve el nombre del primer item popular
	 */
	public String getNamePrimerPopularItem() {
		SeleniumUtilities.waitLoadElement(namePopularItemsLocator, driver);
		SeleniumUtilities.waitClickeableElement(popularDetailsItem0Locator, driver);
		return driver.findElement(popularNameItem0Locator).getText();
	}
	
	/**
	 * Metodo que abre el carrito de compras
	 */
	public void irAlCarritoButton() {
		SeleniumUtilities.waitLoadElement(iconBuyCarLocator, driver);
		driver.findElement(iconBuyCarLocator).click();
	}
	

}
