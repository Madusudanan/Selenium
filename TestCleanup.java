//Imports
//Make sure you have Apache Commons IO in your buildpath
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class TestCleanup {

//Kills the process by the name you specify to it	
public static void killProcess(String ProcessName) throws IOException {
		Runtime.getRuntime().exec("taskkill /f /im " + ProcessName + ".exe");
}

//Clear the temp folder
//Gets the temp folder property from the System property itself
public static void clearTempFolder() throws IOException {
	
	try {
			File file = new File(System.getProperty("java.io.tmpdir"));
			FileUtils.cleanDirectory(file);
	}

	catch (IOException e) {
			// Do nothing since we do not worry about the files that cannot be deleted
			// Include exception handler logic if you want to
		}
	}

}
