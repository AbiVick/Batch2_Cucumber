package aPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherDetails {

	@Test
	public void getWeatherDetails() {

		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";

		RequestSpecification httpReq = RestAssured.given();

		Response resp = httpReq.request(Method.GET, "?q=london&appid=c76e6d1f2e6af75573c66176b1ad5627");

		int acutalStatusCode = resp.getStatusCode();
		Assert.assertEquals(acutalStatusCode, 200);

		System.out.println("===================Response ==============================");
		String actualResponseContent = resp.getBody().asPrettyString();
		System.out.println(actualResponseContent);
		Assert.assertTrue(actualResponseContent.contains("London"));

	}

}
