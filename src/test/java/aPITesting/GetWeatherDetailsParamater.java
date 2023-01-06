package aPITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import junit.framework.Assert;
import utility.Constants;

public class GetWeatherDetailsParamater {

	RequestSpecification httpReq;

	@BeforeTest()
	public void setup() {

		RestAssured.baseURI = "https://api.openweathermap.org";

		httpReq = RestAssured.given();

	}

	@Test(dataProvider = "cityData")
	public void verifyUniversityTest(String CityWeather, String demo) {

		httpReq.param("appid", Constants.apiKey);
		httpReq.param(demo, CityWeather);

		Response resp = httpReq.request(Method.GET, "/data/2.5/weather");

		// validation Step
		int acutalStatusCode = resp.getStatusCode();
		Assert.assertEquals(acutalStatusCode, 200);

		System.out.println("===================Response ==============================");
		System.out.println(resp.getBody().asPrettyString());

		System.out.println("ContentType: " + resp.getContentType()); // JSON format
		System.out.println("ContentType Header : " + resp.getHeader("Content-Type"));
		System.out.println("ResponseTime: " + resp.getTime());
		System.out.println("Status Line: " + resp.getStatusLine());

	}

	@DataProvider
	public Object[][] cityData() {

		Object[][] cityInfo = { {"delhi" , "q"}, {"london" , "q"}, {"jaipur" , "q"} };
		return cityInfo;

	}
}
