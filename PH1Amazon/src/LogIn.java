import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
	public static void main(String[] args)
	{
	    System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		System.out.println("Hello world!");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("nav-search-bar-form")).submit();
		driver.findElement(By.id("a-autoid-0-announce")).click();
		System.out.println("Searching started ");

		driver.findElement(By.id("s-result-sort-select_2")).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Related searches']")));
		List<WebElement> resultsList = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
		int size = resultsList.size();
		System.out.println("Size of list = " + size);
		resultsList.get(2).click();   
	}}