package com.jsp.chart20.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.chart20.Model.EntityData;
import com.jsp.chart20.Model.IntensityData;
import com.jsp.chart20.service.ServiceInterface;

@Controller
public class DataController {
	@Autowired
	private ServiceInterface serviceInterface;
	
	@RequestMapping("/")
	public String IndexMapping() {
		return "index.html";
	}
	
	@GetMapping("/topiclinechart")
	public String getDetailsByCity(Model model) {
		List<String> city = serviceInterface.getCityAllDetails().stream().map(x->x.getCity()).collect(Collectors.toList());
		HashMap<String, Integer> dupli = new HashMap<String, Integer>();
		for(int i=0;i<city.size();i++) {
			if(!dupli.containsKey(city.get(i))) {
				dupli.put(city.get(i), 1);
			}else {
				int temp = dupli.get(city.get(i));
				dupli.put(city.get(i),++temp);
			}
		}
		List<String> value = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : dupli.entrySet()) {
			value.add(entry.getKey());
			count.add(entry.getValue());
		}
		System.out.println(value);
		System.out.println(count);
		System.out.println("#########################");
		model.addAttribute("city", value);
		model.addAttribute("topic", count);
		return "topiclinechart.html";
	}
	@GetMapping("/barChart")
	public String getRegionDetails(Model model) {
	List<EntityData> data=serviceInterface.getRegionDetails().stream().toList();
	HashMap<String,Integer> hash = new HashMap<>();
	for(int i=0;i<data.size();i++) {
		if(!hash.containsKey(data.get(i).getRegion())) {
			hash.put(data.get(i).getRegion(), data.get(i).getIntensity());
		}else {
			int value = hash.get(data.get(i).getRegion());
			int maxvalue = Math.max(value, data.get(i).getIntensity());
			hash.put(data.get(i).getRegion(), maxvalue);
		}
	}
	
	List<String> value = new ArrayList<>();
	List<Integer> count = new ArrayList<>();
	for(Map.Entry<String, Integer> entry : hash.entrySet()) {
		value.add(entry.getKey());
		count.add(entry.getValue());
	}
	System.out.println(value);
	System.out.println(count);
	model.addAttribute("data", value);
	model.addAttribute("count", count);
	return "barChart.html";
	}
	@GetMapping("/topicbarChart")
	public String getTopicDetails(Model model) {
	List<EntityData> getTopicDetails=serviceInterface.getTopicDetails().stream().toList();
	HashMap<String,Integer> hash = new HashMap<String, Integer>();
	for(int i=0;i<getTopicDetails.size();i++) {
		if(!hash.containsKey(getTopicDetails.get(i).getTopic())) {
			hash.put(getTopicDetails.get(i).getTopic(), getTopicDetails.get(i).getEnd_year());
		}else {
			int check = hash.get(getTopicDetails.get(i).getTopic());
			int value = Math.max(check, getTopicDetails.get(i).getEnd_year());
			hash.put(getTopicDetails.get(i).getTopic(),value);
			
		}
	}
	List<String> value = new ArrayList<>();
	List<Integer> count = new ArrayList<>();
	for(Map.Entry<String, Integer> entry : hash.entrySet()) {
		value.add(entry.getKey());
		count.add(entry.getValue());
	}
	System.out.println(value);
	System.out.println(count);
	model.addAttribute("data", value);
	model.addAttribute("count", count);
	return "topicbarChart.html";
	}
	@GetMapping("/countrylinechart")
	public String getCountryDetails(Model model) {
		List<EntityData> getCountryDetails=serviceInterface.getCountryDetails().stream().toList();
		HashMap<String,Integer> hash = new HashMap<String, Integer>();
		for(int i=0;i<getCountryDetails.size();i++) {
			if(!hash.containsKey(getCountryDetails.get(i).getCountry())) {
				hash.put(getCountryDetails.get(i).getCountry(),Integer.valueOf(getCountryDetails.get(i).getImpact()));
			}else {
				int check = hash.get(getCountryDetails.get(i).getCountry());
				int value = Math.max(check,Integer.valueOf(getCountryDetails.get(i).getImpact()));
				hash.put(getCountryDetails.get(i).getCountry(),value);
				
			}
		}
		List<String> value = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : hash.entrySet()) {
			value.add(entry.getKey());
			count.add(entry.getValue());
		}
		System.out.println(value);
		System.out.println(count);
		model.addAttribute("data", value);
		model.addAttribute("count", count);
		return "countrylinechart.html";
	}
	@GetMapping("/yearBarColumn")
	public String getyearDetails(Model model) {
	List<EntityData> getyearDetails=serviceInterface.getyearDetails().stream().toList();
	HashMap<String,Integer> hash = new HashMap<String, Integer>();
	for(int i=0;i<getyearDetails.size();i++) {
		if(!hash.containsKey(getyearDetails.get(i).getStart_year())) {
			hash.put(getyearDetails.get(i).getStart_year(),Integer.valueOf(getyearDetails.get(i).getLikelihood()));
		}else {
			int check = hash.get(getyearDetails.get(i).getStart_year());
			int value = Math.max(check,Integer.valueOf(getyearDetails.get(i).getLikelihood()));
			hash.put(getyearDetails.get(i).getStart_year(),value);
			
		}
	}
	List<String> value = new ArrayList<>();
	List<Integer> count = new ArrayList<>();
	for(Map.Entry<String, Integer> entry : hash.entrySet()) {
		if(!entry.getKey().isEmpty()){
		value.add(entry.getKey());
		count.add(entry.getValue());
		}
	}
	System.out.println(value);
	System.out.println(count);
	model.addAttribute("categories", value);
	model.addAttribute("data", count);
	return "yearBarColumn.html";
	}
	@GetMapping("/RelevanceLineChart")
	public String getRelevanceDetails(Model model) {
		List<EntityData> getRelevanceDetails=serviceInterface.getRelevanceDetails().stream().toList();
		HashMap<String,Integer> hash = new HashMap<String, Integer>();
		for(int i=0;i<getRelevanceDetails.size();i++) {
			hash.put(getRelevanceDetails.get(i).getTopic(),getRelevanceDetails.get(i).getRelevance());
		}
		List<String> value = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : hash.entrySet()) {
			if(!entry.getKey().isEmpty()){
			value.add(entry.getKey());
			count.add(entry.getValue());
			}
		}
		System.out.println(value);
//		System.out.println(count.size());
		model.addAttribute("categories", value);
		model.addAttribute("data", count);
		return "RelevanceLineChart.html";
	}
	@GetMapping("/LikelihoodLineChart")
	public String getLikelihoodDetails(Model model) {
		List<EntityData> getLikelihoodDetails=serviceInterface.getLikelihoodDetails().stream().toList();
		HashMap<String,Integer> hash = new HashMap<String, Integer>();
		for(int i=0;i<getLikelihoodDetails.size();i++) {
			hash.put(getLikelihoodDetails.get(i).getCountry(),getLikelihoodDetails.get(i).getLikelihood());
		}
		List<String> value = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : hash.entrySet()) {
			if(!entry.getKey().isEmpty()){
			value.add(entry.getKey());
			count.add(entry.getValue());
			}
		}
		System.out.println(value);
		System.out.println(count);
		model.addAttribute("categories", value);
		model.addAttribute("data", count);
		return "LikelihoodLineChart.html";
	}
	
	@GetMapping("/IntensityLineChart")
	public String getIntensityDetails(Model model) {
	List<IntensityData> getIntensityDetails=serviceInterface.getIntensityDetails().stream().toList();
	HashMap<String,Integer> hash = new HashMap<String, Integer>();
	for(int i=0;i<getIntensityDetails.size();i++) {
		hash.put(getIntensityDetails.get(i).getTopic(),getIntensityDetails.get(i).getIntensity());
	}
	List<String> value = new ArrayList<>();
	List<Integer> count = new ArrayList<>();
	for(Map.Entry<String, Integer> entry : hash.entrySet()) {
		if(!entry.getKey().isEmpty()){
		value.add(entry.getKey());
		count.add(entry.getValue());
		}
	}
	System.out.println(value);
	System.out.println(count);
	model.addAttribute("categories", value);
	model.addAttribute("data", count);
	return "IntensityLineChart.html";
	}
}





//List<IntensityData> getIntensityDetails=serviceInterface.getIntensityDetails().stream().toList();
//System.out.println(getIntensityDetails);
//System.out.println("#########################");
