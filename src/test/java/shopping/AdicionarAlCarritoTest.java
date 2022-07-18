package shopping;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.BaseSeleniumTest;

public class AdicionarAlCarritoTest extends BaseSeleniumTest {
	

	@Test
	/**
	 * Test que valida que se navegue correctamente al item que se muestra en la informacion de popular Items
	 */
	public void validarInformacionItem() {
		PopularItemsPage page = new PopularItemsPage(driver);
		page.clicPopularItems();
		
		String primerItem = page.getNamePrimerPopularItem();
		page.clicDetallesPrimerItem();
		
		ItemPage itemPage = new ItemPage(driver);
		itemPage.getNameItem();
		
		assertTrue(primerItem.equals(itemPage.getNameItem()));

	}
	
	@Test
	/**
	 * Test que valida que se permita adicionar un item de otro color al carrito
	 */
	public void adicionarTabletOtroColor() {
		PopularItemsPage page = new PopularItemsPage(driver);
		page.clicPopularItems();
		page.clicDetallesPrimerItem();
		
		ItemPage itemPage = new ItemPage(driver);
		String nameItem = itemPage.getNameItem();
		String price = itemPage.getPriceItem();
		String color = "GRAY";
		String cantidad = "1";
		itemPage.setQuantityItem(cantidad);
		itemPage.setColorItem(color);
		itemPage.clicAddToCar();
		
		page.irAlCarritoButton();	
		
		CarritoDeComprasPage carritoPage = new CarritoDeComprasPage(driver);
		carritoPage.getPriceItem();
		
		assertTrue(nameItem.equals(carritoPage.getNameItem()));
		assertTrue(color.equals(carritoPage.getColorItem()));
		assertTrue(cantidad.equals(carritoPage.getQuantyItem()));
		assertTrue(price.equals(carritoPage.getPriceItem()));

	}
	

}
