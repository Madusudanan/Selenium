/* Code to highlight a web element in Selenium.Makes use of Javascript to highlight.
 * This class implements the AbstractWebDriverEventListener.
 * Create an Object of this class type and register it with a EventFiringWebDriver. 
 * Make sure you do all the web driver operations on the EventFiringWebDriver,so that the logging happens here.
 * There are several other methods in the AbstractWebDriverEventListener.You can implement/use it if required
*/

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebElementHighlighterAsEventListener extends AbstractWebDriverEventListener {

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		arg1 = arg2.findElement(arg0);
		for (int i = 0; i < 1; i++) {

			JavascriptExecutor js = (JavascriptExecutor) arg2;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);", arg1,
					"color: black; border: 3px solid black;");
		}

	}

}
