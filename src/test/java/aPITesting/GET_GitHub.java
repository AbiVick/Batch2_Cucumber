package aPITesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;

public class GET_GitHub {

RequestSpecification httpRequest;
    
    @Test
    public void verifyGetuserTest() {       
        
        baseURI = "https://api.github.com";       
        
        given().
            header("Content-Type", "application/json").
            auth().
            	oauth2("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").            
        
        when().
            get("/user/repos").
        
        then().
            statusCode(200).
            body("[1].full_name", equalTo("AbiVick/IBMlearning_GitRepo_temp")).    
            log().all();
        
    }
	
}
