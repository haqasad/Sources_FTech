package basics;

//public class Main {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass test = new TestClass();
		test.invokeBrowser();
		test.checkTitle();

	}*/
	
	import static org.hamcrest.MatcherAssert.assertThat;
	import static org.hamcrest.Matchers.equalToIgnoringCase;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import static org.hamcrest.MatcherAssert.assertThat;
	import static org.hamcrest.Matchers.equalToIgnoringCase;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	
	public class Main {
	
		public static void main(String[] args) {
			
			InvokeFirefox fox = new InvokeFirefox();
			fox.openBrowser();
		}
		
}

