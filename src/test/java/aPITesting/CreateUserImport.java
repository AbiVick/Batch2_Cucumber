package aPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserImport {

	 RequestSpecification httpRequest;
	    Response resp;

	    @Test(priority = -1)
	    public void setup() throws Exception {

	        JSONObject requestBody = new JSONObject();

	        requestBody.put("name", "Priya");
	        requestBody.put("job", "leader");

	        Thread.sleep(4000);
	        System.out.println(requestBody.toJSONString());

	        
	        
	        
	        
	        
	        
	        // BDD - given

	        baseURI = "https://reqres.in";

	        
	        given().
	            headers("Content-Type", "application/json").
	            body(requestBody).
	            
	        when().
	            post("/api/users").
	        
	        then().
	            statusCode(201).
	            body("name", equalTo("Priya")).
	            body("job", equalTo("leader")).
	            log().all();
	      
	    }
	
}
