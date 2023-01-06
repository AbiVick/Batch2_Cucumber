package aPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import junit.framework.Assert;

public class GetUniversity {

	@Test
	public void verifyUniversityTest() {

		// http://universities.hipolabs.com/search?country=India

		// get("/lotto").then().assertThat().body("lotto.lottoId", equalTo(5));

		RestAssured.baseURI = "http://universities.hipolabs.com";

		RequestSpecification httpReq = RestAssured.given();

		Response resp = httpReq.request(Method.GET, "/search?country=India");

		// given().
		// //request
		// when().
		// //action
		// then();
		// //validation

		// validation Step
		int acutalStatusCode = resp.getStatusCode();
		Assert.assertEquals(acutalStatusCode, 200);

		System.out.println("===================Response ==============================");
		System.out.println(resp.getBody().asPrettyString());

	}

}
