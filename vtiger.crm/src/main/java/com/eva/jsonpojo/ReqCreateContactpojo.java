package com.eva.jsonpojo;

import java.util.List;

public class ReqCreateContactpojo {

	private String star_value;

	private String lead_score; 
	private List<String> tags;

	private List<Reqpropertiespojo> properties;


	public List<Reqpropertiespojo> getProperties() {
		return properties;
	}
	public void setProperties(List<Reqpropertiespojo> properties) {
		this.properties = properties;
	}


	public void setStar_value(String star_value) {
		this.star_value = star_value;
	}
	public String getstar_value() {
		return star_value;
	}



	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}



	public String getlead_score() {
		return lead_score;
	}

	public void setlead_score(String Leadscore) {
		lead_score=Leadscore;
	}




}
