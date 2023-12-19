package com.jsp.chart20.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EntityData {
	@Id
	private int id;
	private int end_year;
	private String citylng;
	private String citylat;
	private int intensity;
	private String sector;
	private String topic;
	private String insight;
	private String swot;
	private String url;
	private String region;
	private String start_year;
	private String impact;
	private String added;
	private String published;
	private String city;
	private String country;
	private int relevance;
	private String pestle;
	private String source;
	private String title;
	private int likelihood;
	public EntityData(int id, int end_year, String citylng, String citylat, int intensity, String sector, String topic,
			String insight, String swot, String url, String region, String start_year, String impact, String added,
			String published, String city, String country, int relevance, String pestle, String source, String title,
			int likelihood) {
		super();
		this.id = id;
		this.end_year = end_year;
		this.citylng = citylng;
		this.citylat = citylat;
		this.intensity = intensity;
		this.sector = sector;
		this.topic = topic;
		this.insight = insight;
		this.swot = swot;
		this.url = url;
		this.region = region;
		this.start_year = start_year;
		this.impact = impact;
		this.added = added;
		this.published = published;
		this.city = city;
		this.country = country;
		this.relevance = relevance;
		this.pestle = pestle;
		this.source = source;
		this.title = title;
		this.likelihood = likelihood;
	}
	public EntityData() {
		super();
	}
	
}
