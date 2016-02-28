package core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Linear_framework {
    public static void main(String[] args) {
    String text_case_id = "TC-001.01";
    String text_case_id1 = "TC-001.02";
    String text_case_id2 = "TC-001.03";
    String text_case_id3 = "TC-001.04";
    String text_case_id4 = "TC-001.05";
    String text_case_id5 = "TC-001.06";
    String text_case_id6 = "TC-001.07";
    String url = "http://www.macys.com";
    String id = "525736";
    String Ms_title = "Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com";
    String actual_id;
    WebDriver driver = new FirefoxDriver();
    
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String title_sign_up_actual = driver.getTitle();								//TC-001.01
	
	
    driver.manage().window().maximize();
    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);				//TC-001.01
    driver.findElement(By.id("subnavSearchSubmit")).click();
   
	actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim();  // Web ID: 1762403
   	if (actual_id.equals("")) 
   		{
   		driver.findElement(By.id("toogleText")).click();
   		actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim(); 
   		}/*if*/

    List<WebElement> sizes = driver.findElements(By.xpath("//div[1]/div/div[1]/div[1]/div/div[1]/ul/li"));
    List<String> ls = new ArrayList<String>();
    for (WebElement size : sizes) 
    {ls.add(size.getText());} //for	[King, Queen, California King, Full]
//    ls.add("sss");																делаем FAIL TC-001.07
    
    System.out.println("============================================");				//TC-001.01
     try
	{
    if (Ms_title.equals(title_sign_up_actual)) 
    	{System.out.println("Test Case ID: \t\t" + text_case_id + " - PASSED");
    	System.out.println("Title Expected is :\t" + Ms_title);
    	System.out.println("Title Actual is:\t" + title_sign_up_actual);}/*if*/ 
    else 
    	{
    	System.out.println("Test Case ID: \t\t" + text_case_id + " - FAILED");
    	System.out.println("Title Expected is:\t\t" + Ms_title + "/" + title_sign_up_actual);
    	System.out.println("Title Actual is:\t\t" + Ms_title + "/" + title_sign_up_actual);
    	} 
	}/*try*/ catch (Exception e) 
	{System.out.println("Test Case ID: \t\t" + text_case_id + " - FAILED");
	System.out.println("Title Actual didn't find");}//try
    System.out.println("============================================");				//TC-001.02   
 	if (driver.findElements(By.id("globalSearchInputField")).isEmpty()) 
 	{System.out.println("Test Case ID: \t\t" + text_case_id1 + " - FAILED");
	System.out.println("macys.com page doesn't contain input field Global search");}
 	else
 	{    	System.out.println("Test Case ID: \t\t" + text_case_id1 + " - PASSED");
	System.out.println("macys.com page contains input field Global seatch");}
    System.out.println("============================================");				//TC-001.03
    
    	if (driver.findElements(By.id("subnavSearchSubmit")).isEmpty()) 
    	{System.out.println("Test Case ID: \t\t" + text_case_id2 + " - FAILED");
		System.out.println("macys.com page doesn't contain button Search submit");}
    	else
    	{System.out.println("Test Case ID: \t\t" + text_case_id2 + " - PASSED");
    	System.out.println("macys.com page contains button Search submit");}  
    	
    System.out.println("============================================");				//TC-001.04 

    String[] sPartsStr =	{"CLOSEOUT! Calvin Klein Marin Comforter and Duvet Cover Sets",    		
    						"Bedding Collections",
    						"Bed & Bath",
							"Macy's"	
    						};//String[] sPartsStr
	try
	{    
	String title_actual = driver.getTitle();   
    String[] sParts = title_actual.split(" - "); 
     if (sParts[0].equals(sPartsStr[0]) && 
    	(sParts[1].equals(sPartsStr[1])) && 
    	(sParts[2].equals(sPartsStr[2])) && 
    	(sParts[3].equals(sPartsStr[3]))) 
 	{System.out.println("Test Case ID: \t\t" + text_case_id3 + " - PASSED");
 	System.out.println("Title Expected is:\t" + sParts[0]);
 	System.out.println("Title Actual is:\t" + sPartsStr[0]);
 	System.out.println("--------");
 	System.out.println("Title Expected is:\t" + sParts[1]);
 	System.out.println("Title Actual is:\t" + sPartsStr[1]);
 	System.out.println("--------");
 	System.out.println("Title Expected is:\t" + sParts[2]);
 	System.out.println("Title Actual is:\t" + sPartsStr[2]);
 	System.out.println("--------");
 	System.out.println("Title Expected is:\t" + sParts[3]);
 	System.out.println("Title Actual is:\t" + sPartsStr[3]);
 	}/*if*/ 
     else
 	{
    System.out.println("Test Case ID: \t\t" + text_case_id3 + " - FAILED");
    System.out.println("Title Expected is:\t" + sParts[0]);
    System.out.println("Title Actual is:\t" + sPartsStr[0]);
    System.out.println("--------");
    System.out.println("Title Expected is:\t" + sParts[1]);
    System.out.println("Title Actual is:\t" + sPartsStr[1]);
    System.out.println("--------");
    System.out.println("Title Expected is:\t" + sParts[2]);
    System.out.println("Title Actual is:\t" + sPartsStr[2]);
    System.out.println("--------");
    System.out.println("Title Expected is:\t" + sParts[3]);
    System.out.println("Title Actual is:\t" + sPartsStr[3]);
    		}//*if*/    		
	}/*try*/ 
    catch (Exception e) 
		{System.out.println("Test Case ID: \t\t" + text_case_id3 + " - FAILED");
		System.out.println("Can't find the title");}//catch      
    System.out.println("============================================");				//TC-001.05  
	try
	{   
    if (id.equals(actual_id))
    {
    System.out.println("Test Case ID: \t\t" + text_case_id4 + " - PASSED");
    System.out.println("ID Expected/Actual: \t" + id + "/" + actual_id);
    	
    }/*if*/ else	{
    System.out.println("Test Case ID: \t\t" + text_case_id4 + " - FAILED");
    System.out.println("ID Expected/Actual: \t" + id + "/" + actual_id);
					}//else
	}/*try*/ 
    catch (Exception e) 
		{System.out.println("Test Case ID: \t\t" + text_case_id4 + " - FAILED");
		System.out.println("Can't find Product ID");}//catch      
    System.out.println("============================================");				//TC-001.06
	try
	{
		if (ls.toString().indexOf("Twin") != -1 || 
			ls.toString().indexOf("Twin XL") != -1 || 
			ls.toString().indexOf("Full") != -1 || 
			ls.toString().indexOf("Full/Quin") != -1 || 
			ls.toString().indexOf("Quin") != -1 || 
			ls.toString().indexOf("King") != -1 || 
			ls.toString().indexOf("California King") != -1)
		{    System.out.println("Test Case ID: \t\t" + text_case_id5 + " - PASSED");
	    System.out.println("Product page contains Size latches Twin or Twin XL or Full or Full/Quin or Quin or King or Californis King");}//if	
		else
		{    System.out.println("Test Case ID: \t\t" + text_case_id5 + " - FAILED");
		System.out.println("Product page doesn't contain Size latches Twin or Twin XL or Full or Full/Quin or Quin or King or Californis King");}//else
	}/*try*/ 
    catch (Exception e) 
		{System.out.println("Test Case ID: \t\t" + text_case_id5 + " - FAILED");
		System.out.println("Can't find Product ID");}//catch
    System.out.println("============================================");				//TC-001.07
    
    List<String> new_sizes = new ArrayList<String>();
    if (ls.contains("Twin")) {new_sizes.add("Twin");}
    if (ls.contains("Twin XL")) {new_sizes.add("Twin XL");}
    if (ls.contains("Full")) {new_sizes.add("Full");}
    if (ls.contains("Full/Queen")) {new_sizes.add("Full/Queen");}
    if (ls.contains("Queen")) {new_sizes.add("Queen");}
    if (ls.contains("King")) {new_sizes.add("King");}
    if (ls.contains("California King")) {new_sizes.add("California King");} //public static List<String> expected_sizes(List<String> ls)    
        
	try
	{
    if (ls.toString().equals(new_sizes.toString())) 
    {
        System.out.println("Test Case ID: \t\t" + text_case_id6 + " - PASSED");
        System.out.println("Size latches appeared in the following order"); 
        System.out.println("Expected string:\t" + new_sizes.toString());
        System.out.println("Actual string:\t\t" + ls.toString());
    }//if
    else
    {
        System.out.println("Test Case ID: \t\t" + text_case_id6 + " - FAILED");
        System.out.println("Size latches doesn't appeared in the following order"); 
        System.out.println("Expected string:\t" + new_sizes.toString());
        System.out.println("Actual string:\t\t" + ls.toString());
    }//else
	}/*try*/ 
    catch (Exception e) 
		{System.out.println("Test Case ID: \t\t" + text_case_id6 + " - FAILED");
		System.out.println("Can't find size laches string");}//catch
    System.out.println("============================================");				//THE END
    
        driver.close();
    }//public static void main(String[] args)
}
