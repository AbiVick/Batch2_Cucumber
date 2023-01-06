package aPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import org.json.JSONObject;
import org.json.XML;

//import javax.swing.text.html.HTML;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLtoJSON {

	 @Test
	    public void testCase1() {
	        
	        //https://run.mocky.io/v3/ce50471d-eaa1-443e-bfa0-971f78259471
	        //https://run.mocky.io/v3/945d92f8-a3d4-46ea-bd4e-16b5e5aca7ba
	        
	        baseURI = "https://run.mocky.io/";
	        
	        String resp = 
	                
	                
	                given().
	                    accept(ContentType.XML).
	                    //header("Content-Type", "application/xml").
	                when().
	                    get("/v3/945d92f8-a3d4-46ea-bd4e-16b5e5aca7ba").
	                thenReturn().asString();
	        
	        
	        //JSONObject json = new JSONObject(resp);
	        JSONObject json = XML.toJSONObject(resp);
	        
	        
	        System.out.println(resp);
	        System.out.println("===============================");
	        System.out.println(json);              
	        
	    }
	
}
