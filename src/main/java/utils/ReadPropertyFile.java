package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static String readFileBrwoserProperty(String browser) throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String BrowserName_Value = prop.getProperty(browser);
		return BrowserName_Value;

	}

	public static String readFileBaseURLProperty() throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String BaseURL = prop.getProperty("baseURL");
		return BaseURL;

	}
	public static String readUserName() throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String USerName = prop.getProperty("username");
		return USerName;

	}
	public static String readPassword() throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String USerName = prop.getProperty("password");
		return USerName;

	}


}
