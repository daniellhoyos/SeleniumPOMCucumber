package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageBase{

	WebDriverWait wait = null;
	
	By addToCardItemsLocator = By.xpath("//div[@class=\"AddToCard\"]");
	By saveToCartLocator = By.xpath("//button[@name=\"save_to_cart\"]");
	By itemOnCartLocator = By.xpath("//span[@class=\"cart ng-binding\"][contains(text(),\"1\")]");

	public ProductPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,20);
	}
	
	public boolean validateItemOnCart() {
		wait.until(ExpectedConditions.presenceOfElementLocated(itemOnCartLocator));
		List<WebElement> itemOnCart = findElements(itemOnCartLocator);
		
		if (!itemOnCart.isEmpty()) {
		    return true;
		} else {
		    System.out.println("no items on cart");
			return false;
		}
	}

	public boolean addToCartFirstItem() {
		wait.until(ExpectedConditions.presenceOfElementLocated(addToCardItemsLocator));
		List<WebElement> addToCardItems = findElements(addToCardItemsLocator);
		
		if (!addToCardItems.isEmpty()) {
			clickelementObscures(addToCardItems.get(0));
		} else {
		    System.out.println("no items found");
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(saveToCartLocator));
		clickelementObscures(saveToCartLocator);
		return validateItemOnCart();
	}
	

}
