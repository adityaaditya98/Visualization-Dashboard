package com.jsp.chart20.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.chart20.Model.EntityData;
import com.jsp.chart20.Model.IntensityData;

public interface DataRepo extends JpaRepository<EntityData, Integer> {
	
	@Query("select p from EntityData p where p.city!=''")
	List<EntityData> getCityAllDetails();
	@Query("select p from EntityData p where p.region!='' and p.topic !=''")
	List<EntityData> getRegionDetails();
	@Query("select p from EntityData p where p.topic!=''")
	List<EntityData> getTopicDetails();
	@Query("select p from EntityData p where p.country!='' and p.impact!=''")
	List<EntityData> getCountryDetails();
	@Query("select p from EntityData p where p.start_year!=''")
	List<EntityData> getyearDetails();
	@Query("select p from EntityData p where p.title!=''")
	List<EntityData> getRelevanceDetails();
	@Query("select p from EntityData p where p.country!=''")
	List<EntityData> getLikelihoodDetails();
	
	@Query("select distinct p.intensity,p.topic from EntityData p where p.topic!='' group by p.intensity,p.topic HAVING MAX(p.intensity) IS NOT NULL")
	List<Object[]> getIntensityDetails();
	
}
