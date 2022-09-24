package RESTAPIGETPOST;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostREquestPractice {
  @Test
  public void addUser() {
	  
	  //base URI
	  RestAssured.baseURI="https://reqres.in/api";
	  
	  //Request Object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //how to add pay load
	  //first we create object
	  JSONObject requestParams= new JSONObject();
	  requestParams.put("name", "morpheus");
	  requestParams.put("job", "Employee");
	  
	  //specify request payload type in the header
	  httpRequest.headers("Content-Type","application/json"); 
	  
	  //Adding payload to request
	  httpRequest.body(requestParams.toJSONString());//convert payload JSON into String
	  
	  //Send Request
	  Response response= httpRequest.request(Method.POST,"/users");
	  
	  //print response body
	  String responseBody=response.getBody().asPrettyString();
	  System.out.println("Response Body: "+responseBody );
	  
	  //print response code
	 int statusCode= response.getStatusCode();
	 System.out.println("Status Code: "+statusCode);
	 
	 //validate status code
	 //Assert.asserEqua
	 
	 //to print data i response body
	 String name=response.jsonPath().get("name");
	 System.out.println(name);
	 
	 String job=response.jsonPath().get("job");
	 System.out.println(job);
	 
	Assert.assertEquals("morpheus", "name");
	Assert.assertEquals("", "");
	 
	  
	  
  }



//@Test
public void loginUser() {
	  
	  //base URI
	  RestAssured.baseURI="https://reqres.in/api";
	  
	  //Request Object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //how to add pay load
	  //first we create object
	  JSONObject requestParams= new JSONObject();
	  requestParams.put("email", "eve.holt@reqres.in");
	  requestParams.put("password", "cityslicka");
	  
	  //specify request payload type in the header
	  httpRequest.headers("Content-Type","application/json"); 
	  
	  //Adding payload to request
	  httpRequest.body(requestParams.toJSONString());//convert payload JSON into String
	  
	  //Send Request
	  Response response= httpRequest.request(Method.POST,"/login");
	  
	  //print response body
	  String responseBody=response.getBody().asPrettyString();
	  System.out.println("Response Body: "+responseBody );
	  
	  //print response code
	 int statusCode= response.getStatusCode();
	 System.out.println("Status Code: "+statusCode);
	 
	
	 //how to read the headers
	 String contentType=response.header("Content-Type");
	 System.out.println("content Type: "+contentType);
	 
	 String Server=response.header("Server");
	 System.out.println("Server: "+Server);
	 
	 
	  //how to print all headers
	 Headers allHeader=response.headers();
	 
	 for(Header header : allHeader) {
		 System.out.println(header.getName() + " " + header.getValue());
	 }
	 
	  
}
}
