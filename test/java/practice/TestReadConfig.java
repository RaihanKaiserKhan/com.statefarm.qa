package practice;

import utils.ReadConfigFile;

public class TestReadConfig {

	public static void main(String[] args) {
		System.out.println(ReadConfigFile.getInstance().getUrl());
		System.out.println(ReadConfigFile.getInstance().getImplicitlyWaitTime());
		System.out.println(ReadConfigFile.getInstance().getPageLoadTime());
		System.out.println(ReadConfigFile.getInstance().getSheetName());
		System.out.println(ReadConfigFile.getInstance().getExcelPath());
		System.out.println(ReadConfigFile.getInstance().getClass());
		System.out.println(ReadConfigFile.getInstance().getInstance());
	}
}
