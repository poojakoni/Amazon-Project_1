package Amazon;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmzoninProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("samsung");
		
		WebElement find = driver.findElement(By.id("nav-search-submit-button"));
		find.click();
		
		List<WebElement>allproduct =driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));		 
			
		 for(int i=0; i<allproduct.size();i++) {
	            System.out.println(allproduct.get(i).getText()+" " + allPrice.get(i).getText());  
	            
		 }
		 String ParentWH= driver.getWindowHandle();
			String ExpectedValue = allproduct.get(0).getText();

			allproduct.get(0).click();

			Set<String> AllWindowHandler =	driver.getWindowHandles();
			for(String win : AllWindowHandler ) {
			System.out.println(win);

			if(!win.equals(ParentWH)) {
					driver.switchTo().window(win);
	  }
	   }
			WebElement title = driver.findElement(By.id("productTitle"));

			String str = title.getText();

			if(str.equals(ExpectedValue)) {
				System.out.println("Title is matching");
			}else {
				System.out.println("Title is not matching");
			}
			driver.quit();
	}
}

