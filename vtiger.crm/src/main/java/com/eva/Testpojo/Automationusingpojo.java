package com.eva.Testpojo;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

import com.eva.jsonpojo.ReqCreateContactpojo;
import com.eva.jsonpojo.Reqpropertiespojo;
import com.eva.jsonpojo.resCreatecontactpojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Automationusingpojo {

	public static void main(String[] args) {
			verifyContactCreationAndDetails();

		// mapper class
		//write value as string  
	}

	public static void verifyContactCreationAndDetails() {
try {
	
}catch(Exception e) {
	
}
		String emails=	RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		
		
		ReqCreateContactpojo reqcontact =new ReqCreateContactpojo();
		reqcontact.setStar_value("4");
		reqcontact.setlead_score("786");

		ArrayList<String> listtogarray=new ArrayList<String>();
		listtogarray.add("good");
		listtogarray.add("rich");
		reqcontact.setTags(listtogarray);

		Reqpropertiespojo FirstNameProperues=new Reqpropertiespojo();
		FirstNameProperues.setType("SYSTEM");
		FirstNameProperues.setName("first_name");
		FirstNameProperues.setValue("Sarvesh");

		Reqpropertiespojo LastNameProperues=new Reqpropertiespojo();
		LastNameProperues.setType("SYSTEM");
		LastNameProperues.setName("last_name");
		LastNameProperues.setValue("kumar");

		// guru99 to learn manual testing

		Reqpropertiespojo EmailsProperties=new Reqpropertiespojo();
		EmailsProperties.setType("SYSTEM");
		EmailsProperties.setName("email");
		EmailsProperties.setC("work");
		EmailsProperties.setValue(emails);

		Reqpropertiespojo AddressProperties=new Reqpropertiespojo();
		FirstNameProperues.setType("SYSTEM");
		FirstNameProperues.setName("address");
		FirstNameProperues.setValue("Uttar Pradesh");


		Reqpropertiespojo phoneProperties=new Reqpropertiespojo();
		phoneProperties.setName("phone");
		phoneProperties.setValue("8929435344");
		phoneProperties.setSubtype("work");

		Reqpropertiespojo HomePhoneProperties=new Reqpropertiespojo();
		HomePhoneProperties.setName("phone");
		HomePhoneProperties.setValue("8929435344");
		HomePhoneProperties.setSubtype("home");

		Reqpropertiespojo WebsiteProperties=new Reqpropertiespojo();
		WebsiteProperties.setName("website");
		WebsiteProperties.setValue("www.youtube.com");
		WebsiteProperties.setSubtype("YOUTUBE");


		Reqpropertiespojo URLWebsiteProperties=new Reqpropertiespojo();
		URLWebsiteProperties.setName("website");
		URLWebsiteProperties.setValue("www.gkgyan.in");
		URLWebsiteProperties.setSubtype("URL");

		Reqpropertiespojo MyTextProperties=new Reqpropertiespojo();
		MyTextProperties.setName("My custom field of type text");
		MyTextProperties.setType("CUSTOM");
		MyTextProperties.setValue("My name is Sarvesh");

		Reqpropertiespojo MyDateProperties=new Reqpropertiespojo();
		MyDateProperties.setName("My custom field of type date");
		MyDateProperties.setType("CUSTOM");
		MyDateProperties.setValue("234567899");

		Reqpropertiespojo MycheckboxProperties=new Reqpropertiespojo();
		MycheckboxProperties.setName("My custom field of type checkbox");
		MycheckboxProperties.setType("CUSTOM");
		MycheckboxProperties.setValue("of");

		Reqpropertiespojo MylistProperties=new Reqpropertiespojo();
		MylistProperties.setName("My custom field of type list");
		MylistProperties.setType("CUSTOM");
		MylistProperties.setValue("orange");

		Reqpropertiespojo MycompaniesProperties=new Reqpropertiespojo();
		MycompaniesProperties.setName("My custom field of type companies");
		MycompaniesProperties.setType("CUSTOM");
		MycompaniesProperties.setValue("[\\\"234567888768\\\",\\\"5114076984246272\\\",\\\"5746725247516672\\\"]");

		ArrayList<Reqpropertiespojo> Listproperties =	new ArrayList<Reqpropertiespojo>();
		Listproperties.add(FirstNameProperues);
		Listproperties.add(LastNameProperues);
		Listproperties.add(EmailsProperties);
		Listproperties.add(AddressProperties);
		Listproperties.add(phoneProperties);
		Listproperties.add(HomePhoneProperties);
		Listproperties.add(WebsiteProperties);
		Listproperties.add(URLWebsiteProperties);
		Listproperties.add(MyTextProperties);
		Listproperties.add(MyDateProperties);
		Listproperties.add(MycheckboxProperties);
		Listproperties.add(MylistProperties);
		Listproperties.add(MycompaniesProperties);

		reqcontact.setProperties(Listproperties);

		ObjectMapper mapper=new ObjectMapper();
		String jsonData=null;
		try {
			jsonData=mapper.writeValueAsString(reqcontact);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/// search pojo creation from j son //it,s make json response to class response
		
		// that is for serialization java object to j_son object

		Response jsonrsponse =	RestAssured.given().auth().basic("practise@ecomsarvesh.com", "343434").contentType("application/json").body(jsonData).accept("application/json").post("https://ecomsarvesh.agilecrm.com/dev/api/contacts/");
		String jsonvalue = jsonrsponse.getBody().asPrettyString();
		System.out.println(jsonvalue);
		try {
			
			resCreatecontactpojo resObje= 	mapper.readValue(jsonvalue, resCreatecontactpojo.class);//diserialisation
			 long actualID = resObje.getId();
			String id=Long.toBinaryString(actualID);
			if(id.length()==16) {
				System.out.println("id validation passed");
			}else {
				System.out.println("failed id is  =  "+id);
			}
		//ArrayList<Reqpropertiespojo>=	resObje.getProperties();
		   
		    }catch(Exception e) {
		}


	}

}
