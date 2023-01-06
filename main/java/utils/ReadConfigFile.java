package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import io.netty.util.concurrent.ThreadProperties;
import reporting.Loggers;
import utils.ReadConfigFile;

public class ReadConfigFile {
	
	private static ReadConfigFile readConfigFile;
	private static String location = "./configuration/configure.properties";
	private static String url;
	private static int pageLoadTime;
	private static int implicitlyWaitTime;
	private static String excelPath;
	private static String sheetName;
	private static String sheetName2;
	private static String titleFilePath;
	
	private ReadConfigFile() {
	}

	public static ReadConfigFile getInstance() {
		if (readConfigFile == null) {
			readConfigFile = new ReadConfigFile();
			readProperties();
		}
		return readConfigFile;
	}

	private static void readProperties() {
		try {
			FileReader reader = new FileReader(location);
			Properties properties = new Properties();
			properties.load(reader);
			//Top 3 lines are reading the configure.properties file
			url = properties.getProperty("url");
			pageLoadTime = Integer.parseInt(properties.getProperty("pageLoadTime"));
			implicitlyWaitTime = Integer.parseInt(properties.getProperty("implicitlyWaitTime"));
			excelPath = properties.getProperty("excelPath");
			sheetName = properties.getProperty("sheetName");
			sheetName2 = properties.getProperty("sheetName2");
			titleFilePath = properties.getProperty("titleFilePath");
			
		} catch (IOException e) {
			Loggers.log("File Not Found \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		} catch(NumberFormatException e) {
			Loggers.log("Number format in properties not correct \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return url;
	}

	public int getPageLoadTime() {
		return pageLoadTime;
	}

	public int getImplicitlyWaitTime() {
		return implicitlyWaitTime;
	}
	
	public String getExcelPath() {
		return excelPath;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTitleFilePath() {
		return titleFilePath;
	}
	public String getSheetName2() {
		return sheetName2;
	}
}