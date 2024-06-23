package steps;

import static org.hamcrest.CoreMatchers.hasItem;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matcher;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

public class GETPostsSteps {


    public static ResponseOptions<Response> response;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem("Karthik KK"));
    }

    private void assertThat(Object object, Matcher<Iterable<? super String>> hasItem) {
		// TODO Auto-generated method stub
		
	}

	@Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() throws Throwable {
        BDDStyledMethod.PerformContainsCollection();
    }

    @Then("^I should see verify GET Parameter$")
    public void iShouldSeeVerifyGETParameter() throws Throwable {
        BDDStyledMethod.PerformPathParameter();
    }


    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) throws Throwable {

    //    List<List<String>> data = table.raw();

        HashMap<String, String> body = new HashMap();
    //    body.put("email", data.get(1).get(0));
   //     body.put("password", data.get(1).get(1));
        response = RestAssuredExtension.PostOpsWithBody(url, body);
    }
}
