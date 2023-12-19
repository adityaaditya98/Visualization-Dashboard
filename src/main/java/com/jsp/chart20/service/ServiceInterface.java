package com.jsp.chart20.service;

import java.util.Collection;
import java.util.List;

import com.jsp.chart20.Model.EntityData;
import com.jsp.chart20.Model.IntensityData;

public interface ServiceInterface {
	List<EntityData> getCityAllDetails();
	List<EntityData> getRegionDetails();
	List<EntityData> getTopicDetails();
	List<EntityData> getCountryDetails();
	List<EntityData> getyearDetails();
	List<EntityData> getRelevanceDetails();
	List<EntityData> getLikelihoodDetails();
	List<IntensityData> getIntensityDetails();
}
