package com.hyx.douglas.pencher;

public class LngLats {

	private Double startingDistance;
	//经度
	private Double lng;
	//纬度
	private Double lat;

	public Double getStartingDistance() {
		return startingDistance;
	}

	public void setStartingDistance(Double startingDistance) {
		this.startingDistance = startingDistance;
	}

	public LngLats(Double startingDistance, Double lng, Double lat) {
		this.startingDistance = startingDistance;
		this.lng = lng;
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public LngLats() {
	}

	@Override
	public String toString() {
		return "LngLats [startingDistance=" + startingDistance + ", lng=" + lng + ", lat=" + lat + "]";
	}

}
