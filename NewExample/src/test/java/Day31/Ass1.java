package Day31;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse pad");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> Windows = driver.getWindowHandles();
		String Child = null;
		for(String a :Windows)
			if(!a.equalsIgnoreCase(MainWindow))
			{
				Child = a;
			}
		driver.switchTo().window(Child);
		WebElement drpDn = driver.findElement(By.id("quantity"));
		Select drpone = new Select(drpDn);
		drpone.selectByVisibleText("2 ");
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
		
		driver.findElement(By.className("a-declarative")).click();
		
		driver.findElement(By.name("submit.move-to-cart.Sc02cb793-b8e1-414b-af48-772fd84f41ae")).click();
		driver.findElement(By.className("a-button-input")).click();

	}

}
