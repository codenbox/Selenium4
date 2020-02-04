package Selenium4.Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4ScreenShot {

	public WebDriver driver;

	@BeforeMethod
	public void initializeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://codenbox.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void takeScreenShot() throws IOException {

		WebElement logo = driver.findElement(By.xpath("//h1[@class='site-title']//a//img"));
		File srcFile = logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("logo.png"));
		driver.quit();
	}

}
