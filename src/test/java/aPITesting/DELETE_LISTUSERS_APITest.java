package aPITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE_LISTUSERS_APITest {

	RequestSpecification httpRequest;
	Response resp;

	// String name = "Abhishek";
	// String job = "leader";

	@Test(priority = -1, dataProvider = "smokeTestdata")
	public void setup(String name, String job) throws Exception {

		RestAssured.baseURI = "https://reqres.in/";

		// Request Object
		httpRequest = RestAssured.given();

		JSONObject requestBody = new JSONObject();

		requestBody.put("name", name);
		requestBody.put("job", job);

		Thread.sleep(4000);
		System.out.println(requestBody.toJSONString());
		// header
		// httpRequest.header("Content-Type", "application/json");

		// body
		// httpRequest.body(requestBody);

		// Response Object
		resp = httpRequest.request(Method.DELETE, "/api/users/2");

		System.out.println("-----------Response Body-----------------");
		System.out.println(resp.getBody().asPrettyString());

		//
		// System.out.println(resp.getStatusCode());
		// System.out.println(resp.getContentType());
		// System.out.println(resp.getStatusLine());
		// System.out.println(resp.getHeader("X-Powered-By"));

	}

	@Test
	public void verifyStatusCode() {

		Assert.assertEquals(resp.getStatusCode(), 204);
	}

	// @Test
	// public void verifyContentType() {
	//
	// Assert.assertEquals(resp.getContentType(), "application/json;
	// charset=utf-8");
	// }
	//
	//
	// @Test
	// public void verifyStatusLine() {
	//
	// Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
	// }

	@Test
	public void verifyHeader() {

		Assert.assertEquals(resp.getHeader("X-Powered-By"), "Express");
	}

	@AfterTest
	public void tearDown() {

		System.out.println("Test script executed successfully.");

	}

	@DataProvider
	public Object[][] smokeTestdata() {

		Object[][] data = { { "Abirami", "leader" }, { "Danish", "sr.leader" }, { "Priyanka", "sr.leader" },
				{ "Unmesha", "sr.leader" } };
		return data;
	}

}
