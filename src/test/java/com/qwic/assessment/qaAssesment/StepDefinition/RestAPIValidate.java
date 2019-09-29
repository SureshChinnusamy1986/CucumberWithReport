package com.qwic.assessment.qaAssesment.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;

public class RestAPIValidate {
    int responseCode;
    HttpURLConnection con;

    @Given("^I send a GET request to \"([^\"]*)\"$")
    public void i_send_a_GET_request_to(String ReqUrl) throws IOException {
        URL obj = new URL(ReqUrl);
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
    }

    @Then("^the response status should be \"([^\"]*)\"$")
    public void the_response_status_should_be(String expectedResponseCode) throws IOException {
        responseCode = con.getResponseCode();
        int expectedResponseCodeInt = Integer.parseInt(expectedResponseCode);
        Assert.assertEquals(expectedResponseCodeInt, responseCode);
        System.out.println("Response Code : " + responseCode);
    }

    @Then("^the AcutalJSON response should be same as ExpectedJson$")
    public void the_JSON_response_should_be() throws IOException, JSONException {
        String expectedJson = "{\"models\":[\"Alhambra\",\"Altea\",\"Altea XL\",\"Arosa\",\"Cordoba\",\"Cordoba Vario\",\"Exeo\",\"Ibiza\",\"Ibiza ST\",\"Exeo ST\",\"Leon\",\"Leon ST\",\"Inca\",\"Mii\",\"Toledo\"],\"brand\":\"Seat\"}";
        String urlString = "http://localhost:3000/cars";
        URL obj = new URL(urlString);
        con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONArray myResponse = new JSONArray(response.toString());
        String AcutalJson = myResponse.getJSONObject(0).toString();
        //Compare the Actual response Json with the expected Json result"
        Assert.assertEquals(expectedJson, AcutalJson);
    }
}
