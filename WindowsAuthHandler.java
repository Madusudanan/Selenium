//This class is just a demo for handling Windows authentication using Selenium and will not work standalone
//Please go through the Readme file of this repository for more information 

public class WindowsAuthHandler
{
//Create a String Selection for storing/transferring the password
StringSelection stringSelection = new StringSelection("password");
//Now copy the String Selection contents to the clipboard
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//Create a robot to handle the window
Robot robot = new Robot();
//Tell selenium to treat this Windows authentication pop-up as Javascript pop-up 
Alert alert=driver.switchTo().alert(); 
//Get the URL.driver is the Selenium Driver here e.g InternetExplorerDriver,FirefoxDriver etc.
driver.get("the url"); 
//Now Send the User name
alert.sendKeys("username"); 
//Here AWT comes into the picture.First press the tab key to transfer control to the password text field
robot.keyPress(KeyEvent.VK_TAB); 
robot.keyRelease(KeyEvent.VK_TAB);
//Now paste the clipboard contents using CTRL+V combination
robot.keyPress(KeyEvent.VK_CONTROL); 
robot.keyPress(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_V); 
robot.keyRelease(KeyEvent.VK_CONTROL);
//The Pasting is done.Now Press enter to complete the Login function
robot.keyPress(KeyEvent.VK_ENTER); 
robot.keyRelease(KeyEvent.VK_ENTER);
//Optional Pop-Up handler.Use this if you get an Alert Exception
alert.accept();

}
