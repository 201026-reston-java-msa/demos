package com.serializable;

public abstract class Bird {

	private String name;
	private String color;
	private double weight;
	
	public Bird(String name, String color, double weight) {
		super();
		this.name = name;
		this.color = color;
		this.setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight < 0) {
			throw new NegativeMassException();
		}
		this.weight = weight;
	}
	
	
	
	
	
}
