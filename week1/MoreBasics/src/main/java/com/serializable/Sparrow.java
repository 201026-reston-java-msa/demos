package com.serializable;

import java.io.Serializable;

public class Sparrow extends Bird implements Serializable{

	public Sparrow(String name, String color, double weight) {
		super(name, color, weight);
	}

}
