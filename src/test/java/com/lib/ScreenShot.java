package com.lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static void takeScreenShot(WebDriver driver,String screenshotName) {
		
		try {
		//Taking a screenshot and store it as a file format
		TakesScreenshot ts =(TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
		
		System.out.println("Screenshot Taken");
		}
		catch(Exception e){
			System.out.println("Exception while taking a screenshot "+e.getMessage());
		}
	}
}
