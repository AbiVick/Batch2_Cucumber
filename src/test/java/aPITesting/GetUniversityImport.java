package aPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUniversityImport {

	 RequestSpecification httpRequest;
	    Response resp;

	    @Test(priority = -1)
	    public void setup() throws Exception {

//	      JSONObject requestBody = new JSONObject();
	//
//	      requestBody.put("name", ibm_name);
//	      requestBody.put("job", ibm_role);
	//
//	      Thread.sleep(4000);
//	      System.out.println(requestBody.toJSONString());

	        
	        
	        
	        
	        
	        
	        // BDD - given

	        baseURI = "http://universities.hipolabs.com";

	        
	        given().
	            headers("Content-Type", "application/json").
	            //body(requestBody).
	            
	        when().
	            get("/search?country=India").
	        
	        then().
	            statusCode(200).
	            body("[1].name", equalTo("DAV Institute of Engineering & Technology")).
	            log().all();	        

	    }
	
}
