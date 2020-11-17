package com.revature.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Cave;
import com.revature.service.ForestService;

public class DispatcherUtil {
	
	/*
	 * The Jackson ObjectMapper class (com.fasterxml.jackson.databind.ObjectMapper) is the simplest way to parse JSON with Jackson. The Jackson ObjectMapper can parse JSON from a string, stream or file, and create a Java object or object graph representing the parsed JSON. Parsing JSON into Java objects is also referred to as to deserialize Java objects from JSON.

The Jackson ObjectMapper can also create JSON from Java objects. Generating JSON from Java objects is also referred to as to serialize Java objects into JSON.

The Jackson Object mapper can parse JSON into objects of classes developed by you, or into objects of the built-in JSON tree model explained later in this tutorial.

By the way, the reason it is called ObjectMapper is because it maps JSON into Java Objects (deserialization), or Java Objects into JSON (serialization).
	 */

	private ForestService fs = new ForestService();
	private ObjectMapper om = new ObjectMapper();

	public String processGet(String entity, String get) {
		try {
			if (entity.equals("cave")) {
				if (get.equals("all")) {
					return om.writeValueAsString(fs.allCaves());
				}
			} else if (entity.equals("bear")) {
				if (get.equals("all")) {
					return om.writeValueAsString(fs.allBears());
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "error";
	}

}
