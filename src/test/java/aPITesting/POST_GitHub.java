package aPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_GitHub {

RequestSpecification httpRequest;
    
    @Test
    public void verifyCreateuserTest() {
        
        JSONObject requestBody = new JSONObject();
        
        requestBody.put("name", "IBMlearning_GitRepo_temp1");
        //requestBody.put("job", "leader");
        
        
        baseURI = "https://api.github.com";
        
        
        given().
            header("Content-Type", "application/json").
            auth().
            	oauth2("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").            
            body(requestBody).
        
        when().
            post("/user/repos").
        
        then().
            statusCode(201).
            body("name", equalTo("IBMlearning_GitRepo_temp1")).
            header("Content-Type", equalTo("application/json; charset=utf-8")).
            header("X-RateLimit-Used", equalTo("11")).
            log().all();
        
    }
	
}
