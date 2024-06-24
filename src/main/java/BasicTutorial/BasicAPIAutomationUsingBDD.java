package BasicTutorial;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BasicAPIAutomationUsingBDD {

	public static void main(String[] args) {
		// https://reqres.in/ -public API for testing.
		// https://reqres.in/api/users?page=2

		// RestAssured works on BDD style using Gherkin keys

		// given - it accepts all input details
		// when - submit the API
		// then - validate the response using assertion

		RestAssured.baseURI = "https://reqres.in";
		given().log().all().queryParam("page", 2)
		.when().get("api/users");
		//.then().log().all().statusCode(200);
		
		System.out.println("============================================================"); 
		
		given().log().all().queryParam("page", 2)
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when().post("api/users")
		.then().log().all().statusCode(200);
	}
}
