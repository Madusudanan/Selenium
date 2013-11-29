import org.openqa.selenium.WebDriver;

public class SSLErrorHandlerForIE {

	public static void CertErrorHandler(WebDriver driver) {
		// Use the Webdriver instance to navigate to the result of the JS
		driver.navigate().to("javascript:document.getElementById('overriderlink').click()");
	}

}
