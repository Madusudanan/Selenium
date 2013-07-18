/*
* Code to highlight a web element in Selenium.Makes use of Javascript to highlight.
* The underlying method is standalone and if you wish to use it a utility class of your own or something like that,
* You can go ahead and do that instead of having it inside a separate class.
*/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebElementHighlighter {
  
  //Uses black colour.We can use any of the colours that Javascript recognizes.
	public void highlightElement(WebDriver driver, WebElement element) { 
		for (int i = 0; i < 1; i++) { 
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid black;"); 
			 
			 }
		}

}
