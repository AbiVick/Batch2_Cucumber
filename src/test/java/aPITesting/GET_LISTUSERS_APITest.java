package aPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import utility.Constants;

public class GET_LISTUSERS_APITest {

	@Test
	public void verifyListUserTest() {

		// RestAssured
		// Enviornment - QA/DEV/Stage/Prod
		// RestAssured.baseURI = Constants.URI_API_sample;
		RestAssured.baseURI = "https://reqres.in";

		// Request Object

		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response resp = httprequest.request(Method.GET, "/api/users?page=2"); // request sent to serer

		// Print on Consle output

		System.out.println("=================Response body=======================");
		// System.out.println(resp.asString());
		System.out.println(resp.asPrettyString());

		// validation Step

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);

		// Validation Step
		String actualResponseContent = resp.getBody().asPrettyString();
		Assert.assertTrue(actualResponseContent.contains("byron.fields@reqres.in"));

	}

}
