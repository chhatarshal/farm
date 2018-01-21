package org.farm.base.model;


public class Car {
	
private String id;
private String	brand;
private Integer	year;
private String color;
private Integer price;
private Boolean soldState;

public Car() {
	
}

public Car(String randomId,String randomBrand,Integer randomYear,String randomColor,Integer randomPrice
		,Boolean randomSoldState) {
	this.id=randomId;
	this.brand=randomBrand;
	this.year=randomYear;
	this.color=randomColor;
	this.price=randomPrice;
	this.soldState=randomSoldState;
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

public Boolean getSoldState() {
	return soldState;
}

public void setSoldState(Boolean soldState) {
	this.soldState = soldState;
}





}
