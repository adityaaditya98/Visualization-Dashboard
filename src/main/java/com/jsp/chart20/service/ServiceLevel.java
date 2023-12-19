package com.jsp.chart20.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.chart20.Model.EntityData;
import com.jsp.chart20.Model.IntensityData;
import com.jsp.chart20.repo.DataRepo;

@Service
public class ServiceLevel implements ServiceInterface {
	@Autowired
	private DataRepo dataRepo;

	@Override
	public List<EntityData> getCityAllDetails() {
		return dataRepo.getCityAllDetails();
	}

	@Override
	public List<EntityData> getRegionDetails() {
		return dataRepo.getRegionDetails();
	}
//
//	@Override
	public List<EntityData> getTopicDetails() {
		// TODO Auto-generated method stub
		return dataRepo.getTopicDetails();
	}
//
//	@Override
	public List<EntityData> getCountryDetails() {
		// TODO Auto-generated method stub
		return dataRepo.getCountryDetails();
	}
//
//	@Override
	public List<EntityData> getyearDetails() {
		// TODO Auto-generated method stub
		return dataRepo.getyearDetails();
	}
//
//	@Override
	public List<EntityData> getRelevanceDetails() {
		// TODO Auto-generated method stub
		return dataRepo.getRelevanceDetails();
	}
//
//	@Override
	public List<EntityData> getLikelihoodDetails() {
		// TODO Auto-generated method stub
		return dataRepo.getLikelihoodDetails();
	}
//
//	@Override
	public List<IntensityData> getIntensityDetails() {
		// TODO Auto-generated method stub
		List<Object[]> value = dataRepo.getIntensityDetails();
//		for(Object travel[]:value) {
//		IntensityData data = new IntensityData((Integer)travel[0], (String)travel[1]);
//		System.out.println(data);
//		System.out.println("##################");
//		}
		return value.stream().map(o->new IntensityData((Integer) o[0],(String)o[1])).collect(Collectors.toList());
	}


}
