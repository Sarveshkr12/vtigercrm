package Contacts_Apis;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import io.restassured.RestAssured;
import io.restassured.response.Response;





public class Contacts_Apis_validation {
	String url="https://ecomsarvesh.agilecrm.com/dev/api/contacts";


	public void FetchAllContacts() {
		// url="https://ecomsarvesh.agilecrm.com/dev/api/contacts";

		Response resp=	RestAssured.given().accept("application/json").auth().basic("practise@ecomsarvesh.com", "343434").get(url);
		int actualstatuscode=	resp.getStatusCode();

		if(actualstatuscode==200) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}

		String responceJson=resp.getBody().asPrettyString();
		JSONArray jsoArr=new JSONArray(responceJson);
		System.out.println(jsoArr.length());
		//	System.out.println(responceJson);
	}

	public void GetAllID() {
		Response resp=	RestAssured.given().accept("application/json").auth().basic("practise@ecomsarvesh.com", "343434").get(url);
		String val  = resp.getBody().asPrettyString();

		JSONArray jsonarray=		new JSONArray(val);
		int countid=	jsonarray.length();

		for(int i=0;i<=countid-1;i++) {
			JSONObject j=	jsonarray.getJSONObject(i);

			Number actualid=		j.getNumber("id");

			if(actualid.toString().length()==16) {
				System.out.println("Passed");
			}else {
				System.out.println("Failed");
			}
			System.out.println(actualid);

		}



	}







	public void PostContact() {
		String url="https://ecomsarvesh.agilecrm.com/dev/api/contacts";

		String	email=	RandomStringUtils.randomAlphabetic(5)+"@gmail.com";

		String jsonBody="{\r\n"
				+ "    \"star_value\": \"4\",\r\n"
				+ "    \"lead_score\": \"92\",\r\n"
				+ "    \"tags\": [\r\n"
				+ "        \"Lead\",\r\n"
				+ "        \"Likely Buyer\"\r\n"
				+ "    ],\r\n"
				+ "    \"properties\": [\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"first_name\",\r\n"
				+ "            \"value\": \"Samson\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"last_name\",\r\n"
				+ "            \"value\": \"Nolan\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"email\",\r\n"
				+ "            \"subtype\": \"work\",\r\n"
				+ "            \"value\": \""+email+"\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"address\",\r\n"
				+ "            \"value\": \"{\\\"address\\\":\\\"225 George Street\\\",\\\"city\\\":\\\"NSW\\\",\\\"state\\\":\\\"Sydney\\\",\\\"zip\\\":\\\"2000\\\",\\\"country\\\":\\\"Australia\\\"}\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"phone\",\r\n"
				+ "            \"value\": \"8888888889\",\r\n"
				+ "            \"subtype\": \"work\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"phone\",\r\n"
				+ "            \"value\": \"8888888889\",\r\n"
				+ "            \"subtype\": \"home\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.youtube.com\",\r\n"
				+ "            \"subtype\": \"YOUTUBE\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.linkedin.com\",\r\n"
				+ "            \"subtype\": \"LINKEDIN\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.mywebsite.com\",\r\n"
				+ "            \"subtype\": \"URL\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type text\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"My name is ghanshyam\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type date\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": 1479580200\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type checkbox\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"on\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type list\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"lemon\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type companies\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"[\\\"5767466600890368\\\",\\\"5114076984246272\\\",\\\"5746725247516672\\\"]\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";	


		Response res=	RestAssured.given().contentType("application/json").accept("application/json").auth().basic("practise@ecomsarvesh.com", "343434").body(jsonBody).post(url);
		String prettyVal =       res.getBody().asPrettyString();

		JSONObject jobj=	new JSONObject(prettyVal);
		Number  actualID=	jobj.getNumber("id");
		//                                             	int status= res.getStatusCode();
		if(actualID.toString().length()==16) {
			System.out.println("Passed your id is = "+actualID);
		}
		else {
			System.out.println("Failed");
		}
		Number actualId=		jobj.getNumber("id");
		if(actualId.toString().length()==16) {
			System.out.println("Passed");

		}else {
			System.out.println("Failed");
		}


		String ActualtypeValue =  jobj.getString("type");

		if(ActualtypeValue.equalsIgnoreCase("PERSON")) {
			System.out.println("Passed");
		}else {System.out.println("Failed");}

		JSONObject jsonobj=   jobj.getJSONObject("viewed");
		Number actualviwedNUmber = 		jsonobj.getNumber("viewed_time");
		System.out.println(actualviwedNUmber);

	}























}

















