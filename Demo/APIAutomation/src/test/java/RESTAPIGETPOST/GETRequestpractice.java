package RESTAPIGETPOST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequestpractice {
  @Test
  public void listOfUsers() {
	  
	  // Base URI
	  RestAssured.baseURI = "https://reqres.in/api/users";
	  
	  
	  // Request Object
	  RequestSpecification httpRequest = RestAssured.given();//httpRequest will be used to send the request
	  
	 Response response= httpRequest.request(Method.GET,"?page=2"); // we send the get request
	 
	 //how to print response body
	 
	String responseBody= response.getBody().asPrettyString(); //asPrettyString used to convert Json into String
	System.out.println("Response Body: "+responseBody);
	
	//how to read and print status code
	int statusCode=response.getStatusCode();
	System.out.println("Status Code: "+statusCode);
	
	////how to read and print status line
	String statusLine=response.getStatusLine();
	System.out.println("Status Line: "+statusLine);
	
	//How to validate the data
	//first we check status code
	Assert.assertEquals("200", "statusCode");
	//check status line
	Assert.assertEquals("HTTP/1.1 200 OK", "statusLine");
	
	 
	  
  }
}
