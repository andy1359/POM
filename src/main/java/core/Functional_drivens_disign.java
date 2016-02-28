package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Functional_drivens_disign {
    public static void main(String[] args) {
    	String csvFile = null;
    	String xsize = null;
        String url = null;
        String id = null;
        String Ms_title = null;
    	BufferedReader buf = null;
    	String str = null;
    	String SplitBy = ",";
    	String t_c = null;
    	String sPart1 = null;
    	String sPart2 = null;
    	String sPart3 = null;
    	String sPart4 = null;
    	
		//!!!!!!!!!!!!!!!!!!	чтение из properties файла !!!!!!!!!!!!!!!!!! 	
Properties prop = new Properties();    
try {
prop.load(new FileInputStream("./src/main/resources/params.properties"));
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
url = prop.getProperty("url");
Ms_title = prop.getProperty("Ms_title");
csvFile = prop.getProperty("csvFile");
xsize = prop.getProperty("xsize");
		//!!!!!!!!!!!!!!!!!!	чтение из properties файла !!!!!!!!!!!!!!!!!!
    	
    	  // WebDriver driver = new FirefoxDriver();  	    
   		WebDriver driver = new HtmlUnitDriver();
			//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!!  
try {
buf = new BufferedReader(new FileReader(csvFile));		
while ((str = buf.readLine()) != null){
	
String[] csv = str.split(SplitBy);
t_c = csv[0];
id =csv[1];
sPart1 =csv[2];
sPart2 =csv[3];
sPart3 =csv[4];
sPart4 =csv[5];
			//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!!

    	    driver.get(url);    		
      	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String title_sign_up_actual = driver.getTitle();							 		
    	    driver.manage().window().maximize();
    	    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);			//TC-001.01
    	    driver.findElement(By.id("subnavSearchSubmit")).click();
    	   
    	    String actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim();  // Web ID: 1762403
    	   	if (actual_id.equals("")) 
    	   		{
    	   		driver.findElement(By.id("toogleText")).click();
    	   		actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim(); 
    	   		}/*if*/			
    	    
    	   	tc1_2_3 (title_sign_up_actual,t_c,Ms_title,url);					//TC-1,2,3
    	       	    
			 
    	    tc4_5 (url,sPart1,sPart2,sPart3,sPart4,t_c,id,actual_id);						//TC-4,5
				
    	    
    	    tc6_7 (t_c,xsize,id,url);														//TC-6,7
    	    
    	    
}//try											//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
}     catch (Exception e) 						//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
{System.out.println("cvs file not founded");}	//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
    	    
    	        driver.close();
    	    }

    
    	    public static List<String> expected_sizes(List<String> ls) 						
    		{//public static void main(String[] args)
    	           List<String> new_sizes = new ArrayList<String>();
    	           List<String> sizes = ls;
    	           if (sizes.contains("Twin")) {new_sizes.add("Twin");}
    	           if (sizes.contains("Twin XL")) {new_sizes.add("Twin XL");}
    	           if (sizes.contains("Full")) {new_sizes.add("Full");}
    	           if (sizes.contains("Full/Queen")) {new_sizes.add("Full/Queen");}
    	           if (sizes.contains("Queen")) {new_sizes.add("Queen");}
    	           if (sizes.contains("King")) {new_sizes.add("King");}
    	           if (sizes.contains("California King")) {new_sizes.add("California King");}
    	           List<String> expected_sizes = new_sizes;
    	           return expected_sizes;
    		}//public static void main(String[] args)
    	    

   
    		public static void tc1_2_3 (String title_sign_up_actual,String t_c,String Ms_title,String url) 
    		{//public static void tc1	begin
    	  		WebDriver driver = new HtmlUnitDriver();
    //------------------------------------------------------------------------------						//TC-001 
    		System.out.println("============================================");
       	     try
       		{
       	    if (Ms_title.equals(title_sign_up_actual)) 
       	    	{System.out.println("Test Case ID: \t\t" + t_c + ".01" + " - PASSED");
       	    	System.out.println("Title Expected is :\t" + Ms_title);
       	    	System.out.println("Title Actual is:\t" + title_sign_up_actual);}/*if*/ 
       	    else 
       	    	{
       	    	System.out.println("Test Case ID: \t\t" + t_c + ".01" + " - FAILED");
       	    	System.out.println("Title Expected is :\t" + Ms_title);
       	    	System.out.println("Title Actual is:\t" + title_sign_up_actual);
       	    	} 
       		}/*try*/ catch (Exception e) 
       		{System.out.println("Test Case ID: \t\t" + ".01" + " - FAILED");
       		System.out.println("Title Actual didn't find");}//try
       	     
      	    System.out.println("============================================");	 							//TC-02     	     
       	     
 	    	//WebDriver driver = new FirefoxDriver();
 	    	driver.get(url); 
      	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    	
 	    //	driver.findElements(By.id("globalSearchInputField"));
 	    	
 	    	if (driver.findElements(By.id("globalSearchInputField")).isEmpty()) 
 	    	{System.out.println("Test Case ID: \t\t" + t_c + ".02" + " - FAILED");
 			System.out.println(url + " page doesn't contain input field Global search");}
 	    	else
 	    	{System.out.println("Test Case ID: \t\t" + t_c + ".02" + " - PASSED");
 	    	System.out.println(url + " page contains input field Global seatch");}
 	    	    
   	    System.out.println("============================================");									//TC-03

   	    
   	//    driver.findElement(By.id("subnavSearchSubmit")).getText();
    	if (driver.findElements(By.id("subnavSearchSubmit")).isEmpty()) 
	    	{System.out.println("Test Case ID: \t\t" + t_c + ".03" + " - FAILED");
			System.out.println(url + " page doesn't contain button Search submit");}
	    	else
	    	{System.out.println("Test Case ID: \t\t" + t_c + ".03" + " - PASSED");
	    	System.out.println(url + " page contains button Search submit");}    	    
 	   driver.close();
    		}//public static void tc1	end
   		
    //------------------------------------------------------------------------------						//TC-04
       		public static void tc4_5 (String url,String sPart1,String sPart2,String sPart3,String sPart4,String t_c,String id,String actual_id) 
    		{//public static void tc4_5	begin
       	  		WebDriver driver = new HtmlUnitDriver();
        	    System.out.println("============================================");	  
        	    String[] sPartsStr =	{sPart1,    		
						sPart2,			//иногда меняется Duvet Covers на Bedding Collections	???
						sPart3,
						sPart4	
						};//String[] sPartsStr
    	    	//WebDriver driver = new FirefoxDriver();
    	    	driver.get(url);
        	    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);
        	    driver.findElement(By.id("subnavSearchSubmit")).click();
try
{    
String title_actual = driver.getTitle();   
String[] sParts = title_actual.split(" - "); 
 if (sParts[0].equals(sPartsStr[0]) && 
	(sParts[1].equals(sPartsStr[1])) && 
	(sParts[2].equals(sPartsStr[2])) && 
	(sParts[3].equals(sPartsStr[3]))) 
	{System.out.println("Test Case ID: \t\t" + t_c + ".04" + " - PASSED");
	System.out.println("Title Expected is:\t" + sParts[0]);
	System.out.println("Title Actual is:\t" + sPartsStr[0]);
	System.out.println("--------");
	System.out.println("Title Actual is:\t" + sParts[1]);
	System.out.println("Title Expected is:\t" + sPartsStr[1]);
	System.out.println("--------");
	System.out.println("Title Actual is:\t" + sParts[2]);
	System.out.println("Title Expected is:\t" + sPartsStr[2]);
	System.out.println("--------");
	System.out.println("Title Actual is:\t" + sParts[3]);
	System.out.println("Title Expected is:\t" + sPartsStr[3]);
	}/*if*/ 
 else
	{
System.out.println("Test Case ID: \t\t" + t_c +  ".04" + " - FAILED");
System.out.println("Title Actual is:\t" + sParts[0]);
System.out.println("Title Expected is:\t" + sPartsStr[0]);
System.out.println("--------");
System.out.println("Title Actual is:\t" + sParts[1]);
System.out.println("Title Expected is:\t" + sPartsStr[1]);
System.out.println("--------");
System.out.println("Title Actual is:\t" + sParts[2]);
System.out.println("Title Expected is:\t" + sPartsStr[2]);
System.out.println("--------");
System.out.println("Title Actual is:\t" + sParts[3]);
System.out.println("Title Expected is:\t" + sPartsStr[3]);
		}//*if*/    		
}/*try*/ 
catch (Exception e) 
	{System.out.println("Test Case ID: \t\t" + t_c + ".04" + " - FAILED");
	System.out.println("Can't find the title");}//catch
System.out.println("============================================");				//TC-001.05   
try
{   
if (id.equals(actual_id))
{
System.out.println("Test Case ID: \t\t" + t_c + ".05" + " - PASSED");
System.out.println("ID Expected/Actual: \t" + id + "/" + actual_id);
	
}/*if*/ else	{
System.out.println("Test Case ID: \t\t" + t_c + ".05" + " - FAILED");
System.out.println("ID Expected/Actual: \t" + id + "/" + actual_id);
				}//else
}/*try*/ 
catch (Exception e) 
	{System.out.println("Test Case ID: \t\t" + t_c + ".05" + " - FAILED");
	System.out.println("Can't find Product ID");}//catch   
driver.close();  			
    		}//public static void tc4_5	end
       		
       		
public static void tc6_7 (String t_c,String xsize,String id,String url) 
    {//public static void tc6,7	begin
		WebDriver driver = new HtmlUnitDriver();
//	WebDriver driver = new FirefoxDriver();	
    driver.get(url);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);		
    driver.findElement(By.id("subnavSearchSubmit")).click();

    List<WebElement> sizes = driver.findElements(By.xpath(xsize));
    List<String> ls = new ArrayList<String>();
    for (WebElement size : sizes) 
    {ls.add(size.getText());} //for	[King, Queen, California King, Full]
    //ls.add("sss");	делаем FAILED TC-07
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
    			{    System.out.println("Test Case ID: \t\t" + t_c + ".06" + " - PASSED");
    		    System.out.println("Product page contains Size latches Twin or Twin XL or Full or Full/Quin or Quin or King or Californis King");}//if	
    			else
    			{    System.out.println("Test Case ID: \t\t" + t_c + ".06" + " - FAILED");
    		    System.out.println("Product page doesn't contain Size latches Twin or Twin XL or Full or Full/Quin or Quin or King or Californis King");}//else
    		}/*try*/ 
    	    catch (Exception e) 
    			{System.out.println("Test Case ID: \t\t" + ".06" + " - FAILED");
    			System.out.println("Can't find Product ID");}//catch
    	    System.out.println("============================================");				//TC-001.07
    		try
    		{
    	    if (ls.toString().equals(expected_sizes(ls).toString())) 
    	    {
    	        System.out.println("Test Case ID: \t\t" + t_c + ".07" + " - PASSED");
    	        System.out.println("Size latches appeared in the following order"); 
    	        System.out.println("Expected string:\t" + expected_sizes(ls).toString());
    	        System.out.println("Actual string:\t\t" + ls.toString());
    	    }//if
    	    else
    	    {
    	        System.out.println("Test Case ID: \t\t" + t_c + ".07" + " - FAILED");
    	        System.out.println("Size latches doesn't appeared in the following order"); 
    	        System.out.println("Expected string:\t" + expected_sizes(ls).toString());
    	        System.out.println("Actual string:\t\t" + ls.toString());
    	    }//else
    		}/*try*/ 
    	    catch (Exception e) 
    			{System.out.println("Test Case ID: \t\t" + t_c + ".07" + " - FAILED");
    			System.out.println("Can't find size laches string");}//catch
    	    System.out.println("============================================");				//THE END
	        driver.close();
    		}//public static void tc6_7	end       		
       		     		
    	}