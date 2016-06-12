package Uptake;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

/**
 * @author Samantha Stone
 * The below test works in Firefox. It tests the navigation between the Uptake home
 * page and the Approach page.
 * I used Selenium WebDriver for this automated test. Find the website, along with
 * documentation for Selenium WebDriver here:
 * http://www.seleniumhq.org/projects/webdriver/
 */
public class UptakeChallenge {

	/**
	 * testNavigation tests whether the given element is linking to the expected URL.
	 * Whether the test passes or fails will be printed to the console, and returned in
	 * the form of a boolean.
	 * @param driver, a Selenium WebDriver
	 * @param baseURL, the starting URL
	 * @param element, the element that the test should pragmatically click on
	 * @param expectedURL, the final expected URL after clicking that element
	 * @return boolean; true for passing the test, false for failing
	 */
	public static boolean testNavigation(WebDriver driver, String baseURL, String element, String expectedURL){
		String actualURL = "";
		boolean result = false;
		// launch Firefox and direct it to the base URL
        driver.get(baseURL);
        
        //click on the given element
        driver.findElement(By.className(element)).click();
        
        // get the actual value of the URL after clicking
        actualURL = driver.getCurrentUrl();
       
        // compare the actual URL of the page after clicking with the
        // expected one and print the result as "Test Passed" or "Test Failed"
        if (actualURL.equals(expectedURL)){
        	System.out.println("Test Passed :)");
            result = true;
        } else {
            System.out.println("Test Failed :(");
            result = false;
        }
        
        //close Firefox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
        
        return result;
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// define starting point, element to click on, and expected final URL
        String baseURL = "http://uptake.com/";
        String element = "menu-item-4164"; //className
        String expectedURL = "http://uptake.com/approach/";
        
        //call testNavigation to test navigation between starting page and final page
        testNavigation(driver, baseURL, element, expectedURL);
	}

}
