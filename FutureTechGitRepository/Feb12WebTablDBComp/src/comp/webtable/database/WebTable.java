package comp.webtable.database;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable {

	public static void main( String[] args ) {

		WebDriver driver = new FirefoxDriver();
//		driver.get("localhost/webtable.html");;
		driver.get("http://localhost:8080/asad/index.html");


		WebElement htmltable=driver.findElement(By.xpath("//*[@id='test']"));

		List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
		System.out.println("Number of rows:"+  rows.size());

		for(int rnum=0;rnum<rows.size();rnum++)

		{
			List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
			System.out.println("Number of columns:"+columns.size());

			for(int cnum=0;cnum<columns.size();cnum++)
			{
				System.out.println(columns.get(cnum).getText());
			}
		}
	}
}
