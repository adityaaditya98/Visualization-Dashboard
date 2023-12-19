package com.jsp.chart20.Model;

import lombok.Data;

@Data
public class IntensityData {
private int intensity;
private String topic;

public IntensityData(Integer intensity, String topic) {
	super();
	this.intensity = intensity;
	this.topic = topic;
}
public IntensityData() {
	super();
}

}
