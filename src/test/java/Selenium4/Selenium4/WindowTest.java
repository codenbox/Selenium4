package Selenium4.Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTest {

	public WebDriver driver;

	@BeforeMethod
	public void initializerDrive() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://codenbox.com/");
		System.out.println("Successfully launched the codenbox site");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// @Test
	public void openNewTab() {

		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("http://codenboxautomationlab.com/");
		System.out.println("The title of the page is:");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("http://codenboxautomationlab.com/");
		System.out.println("The title of the page is:");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
