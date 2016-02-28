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

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class POM {
		
    public String[][] a2d()
    {
    	String csvFile = null;
        String id = null;
    	BufferedReader buf = null;
    	String str = null;
    	String SplitBy = ",";
    	String t_c = null;
    	String sPart1 = null;
    	String sPart2 = null;
    	String sPart3 = null;
    	String sPart4 = null;
    	String xsize = null;
    	Integer i = 0;
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
csvFile = prop.getProperty("csvFile");
xsize = prop.getProperty("xsize");
		//!!!!!!!!!!!!!!!!!!	чтение из properties файла	!!!!!!!!!!!!!!!!!! 	    
String[][] s2d = null;
String[][] gnrl = null;
String[][] bufarr = null;
		//!!!!!!!!!!!!!!!!!!	чтение из cvs файла 		!!!!!!!!!!!!!!!!!!  
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
		//!!!!!!!!!!!!!!!!!!	чтение из cvs файла 		!!!!!!!!!!!!!!!!!!
			core.POM POM = new core.POM(); 
			
            String s2d123[][] = new String[3][4];
            String s2d45[][] = new String[2][4];
            String s2d67[][] = new String[2][4];
			
            s2d123 = POM.tc1_2_3(t_c);									//TC-1,2,3
            s2d45 = POM.tc4_5 (sPart1,sPart2,sPart3,sPart4,t_c,id,xsize);		//TC-4_5
            s2d67 = POM.tc6_7 (t_c,id,xsize);									//TC-6_7
            String[][] s2d12345 = ArrayUtils.addAll(s2d123, s2d45);
            s2d = ArrayUtils.addAll(s2d12345, s2d67);		//записываем туда значения цикла TC-1
            gnrl = bufarr; 
            bufarr = ArrayUtils.addAll(gnrl, s2d);
            i ++;
       	   	  
}//try											//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
}     catch (Exception e) 						//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
{System.out.println("cvs file not founded");}	//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!! 
i++;    
        return bufarr;
    }	
		
    //=============================================================================================================== main
    public static void main(String[] args) {     	
		core.POM POM = new core.POM();	
		POM.a2d(); 
    	    } 
    //=============================================================================================================== main    
    
    
  //=============================================================================================================== tc1_2_3 
    public String[][] tc1_2_3(String t_c)
	{
        String url = null;
        String Ms_title = null;     	
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
		//!!!!!!!!!!!!!!!!!!	чтение из properties файла !!!!!!!!!!!!!!!!!!
    	
//    	   WebDriver driver = new FirefoxDriver(); 
	WebDriver driver = new HtmlUnitDriver();

			//!!!!!!!!!!!!!!!!!!	чтение из cvs файла !!!!!!!!!!!!!!!!!!  

    	    driver.get(url);    		
      	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String title_sign_up_actual = driver.getTitle();							//TC-001.01  		
    	    driver.manage().window().maximize();
            String s2d[][] = new String[3][5];
            int i = 0;    	    
//    	    System.out.println("============================================");				//TC-001.01
            s2d[i][0] = t_c;
            s2d[i][1] = ".01";
            s2d[i][2] = "test if macys.com page html title";
            s2d[i][3] = Ms_title;
            s2d[i][4] = title_sign_up_actual;
            i++;            
//    	    System.out.println("============================================");				//TC-001.02
            s2d[i][0] = t_c;
            s2d[i][1] = ".02";
            s2d[i][2] = "macys.com page doesn't contain input field Global search";
 	    	s2d[i][3] = Boolean.toString(driver.findElements(By.id("globalSearchInputField")).isEmpty());
 	    	s2d[i][4] = "false";	    	//maysis.com contains field 'global search'
            i++;   	        	        	    
//    	    System.out.println("============================================");				//TC-001.03  
            s2d[i][0] = t_c;
            s2d[i][1] = ".03";
            s2d[i][2] = "macys.com page doesn't contain button Search Submit";
 	   		s2d[i][3] = Boolean.toString(driver.findElements(By.id("subnavSearchSubmit")).isEmpty());
 	   		s2d[i][4] = "false";	    	//maysis.com contains button 'search submit'  
    	        driver.close();
    	        return s2d;
	}//public static void tc1_2_3 (String t_c)
	//=============================================================================================================== tc1_2_3^
	//=============================================================================================================== tc4_5
    		public String[][] tc4_5(String sPart1,String sPart2,String sPart3,String sPart4,String t_c,String id,String xsize)
		{
	        String url = null;
            String s2d[][] = new String[2][5];
            int i = 0;	    	
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
			//!!!!!!!!!!!!!!!!!!	чтение из properties файла !!!!!!!!!!!!!!!!!!    	
	//    	   WebDriver driver = new FirefoxDriver();
	WebDriver driver = new HtmlUnitDriver();

	    	    driver.get(url);    		
	      	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	    	    driver.manage().window().maximize();
	    	    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);
	    	    driver.findElement(By.id("subnavSearchSubmit")).click();    	   
	    	    String actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim();  // Web ID: 1762403
	    	   	if (actual_id.equals("")) 
	    	   		{
	    	   		driver.findElement(By.id("toogleText")).click();
	    	   		actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim(); 
	    	   		}/*if*/

	    	    List<WebElement> sizes = driver.findElements(By.xpath(xsize));
	    	    List<String> ls = new ArrayList<String>();
	    	    for (WebElement size : sizes) 
	    	    {ls.add(size.getText());} //for	[King, Queen, California King, Full]
	       	   		       	   	
	    	//    System.out.println("============================================");				//TC-001.04 

	    	    String[] sPartsStr =	{sPart1,    		
	    	    						sPart2,			//иногда меняется Duvet Covers на Bedding Collections	???
	    	    						sPart3,
	    	    						sPart4	
	    	    						};//String[] sPartsStr
	    		String title_actual = driver.getTitle();
	    	   
	    		s2d[i][0] = t_c;
	            s2d[i][1] = ".04";
	    		s2d[i][2] = "Result page title has format";
	    		s2d[i][3] = title_actual;						//проверяемая переменная с сайта
	    		s2d[i][4] = sPartsStr[0] + " - " + sPartsStr[1]  + " - " + sPartsStr[2] + " - " + sPartsStr[3];;			//сравниваемая переменная(моя) */
	            i++;
	  //  	    System.out.println("============================================");					//TC-001.05   
	    		
	    		s2d[i][0] = t_c;
	            s2d[i][1] = ".05";
	    		s2d[i][2] = "Result page contains Product ID";
	    		s2d[i][3] = actual_id;						//проверяемая переменная с сайта
	    		s2d[i][4] = id;							//сравниваемая переменная(моя) 
  
	    	        driver.close();	
	    	        return s2d;
		}//public static void tc4_5
	//=============================================================================================================== tc4_5^
	//=============================================================================================================== tc6_7
            public String[][] tc6_7 (String t_c,String id,String xsize) 
		{
	        String url = null;
            String s2d[][] = new String[2][5];
            int i = 0;	
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
			//!!!!!!!!!!!!!!!!!!	чтение из properties файла !!!!!!!!!!!!!!!!!!
	    	
	    	//   WebDriver driver = new FirefoxDriver();
	WebDriver driver = new HtmlUnitDriver();

	    	    driver.get(url);    		
	      	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 		
	    	    driver.manage().window().maximize();
	    	    driver.findElement(By.id("globalSearchInputField")).sendKeys(id);			//TC-001.01
	    	    driver.findElement(By.id("subnavSearchSubmit")).click();
	    	    String actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim();  // Web ID: 1762403
	    	   	if (actual_id.equals("")) 
	    	   		{
	    	   		driver.findElement(By.id("toogleText")).click();
	    	   		actual_id = driver.findElement(By.className("productID")).getText().replace("Web ID:", "").trim(); 
	    	   		}/*if*/

	    	    List<WebElement> sizes = driver.findElements(By.xpath(xsize));
	    	    List<String> ls = new ArrayList<String>();
	    	    for (WebElement size : sizes) 
	    	    {ls.add(size.getText());} //for	[King, Queen, California King, Full]
	    	    //ls.add("sss");	портим TC-001.07
	       	   	  
	    	    //System.out.println("============================================");				//TC-001.06
	            s2d[i][0] = t_c;
	            s2d[i][1] = ".06";
	            s2d[i][2] = "Page contains Size apropriate latches";
	    		try	    		
	    		{
	    			if (ls.toString().indexOf("Twin") != -1 || 
	    				ls.toString().indexOf("Twin XL") != -1 || 
	    				ls.toString().indexOf("Full") != -1 || 
	    				ls.toString().indexOf("Full/Quin") != -1 || 
	    				ls.toString().indexOf("Quin") != -1 || 
	    				ls.toString().indexOf("King") != -1 || 
	    				ls.toString().indexOf("California King") != -1)
	    			{s2d[i][3] = "true";}//if	
	    			else
	    			{s2d[i][3] = "false";}//else
	    		}/*try*/ 
	    	    catch (Exception e) 
	    			{s2d[i][3] = "false";}//catch
	    	    s2d[i][4] = "true";
	    	    i++;
	    	//    System.out.println("============================================");				//TC-001.07
	            s2d[i][0] = t_c;
	            s2d[i][1] = ".07";
	            s2d[i][2] = "Size latches appear in the following order";
	    		try
	    		{
	    	    if (ls.toString().equals(expected_sizes(ls).toString())) 
	    	    {s2d[i][3] = "true";}//if
	    	    else
	    	    {s2d[i][3] = "false";}//else
	    		}/*try*/ 
	    	    catch (Exception e) 
	    			{s2d[i][3] = "false";}//catch
	    		s2d[i][4] = "true";
	    	  //  System.out.println("============================================");				//THE END	 
	    	    driver.close();		    	    
    	        return s2d;		
		}
	//=============================================================================================================== tc6_7^
    	    public static List<String> expected_sizes(List<String> ls) 						
    		{//public static void main(String[] args)
    	           List<String> new_sizes = new ArrayList<String>();
    	           List<String> sizes = ls;/**/
    	           if (sizes.contains("Twin")) {new_sizes.add("Twin");}
    	           if (sizes.contains("Twin XL")) {new_sizes.add("Twin XL");}
    	           if (sizes.contains("Full")) {new_sizes.add("Full");}
    	           if (sizes.contains("Full/Queen")) {new_sizes.add("Full/Queen");}
    	           if (sizes.contains("Queen")) {new_sizes.add("Queen");}
    	           if (sizes.contains("King")) {new_sizes.add("King");}
    	           if (sizes.contains("California King")) {new_sizes.add("California King");} //public static List<String> expected_sizes(List<String> ls)
    	           List<String> expected_sizes = new_sizes;
    	           return expected_sizes;
    		}//public static void main(String[] args)
    	}