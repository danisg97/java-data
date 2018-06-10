package com.daniel.jsonBDemo;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class MainApplicationJava {

	public static void main(String[] args) {
		
		Dog dogFalco = new Dog("Falco", "4", false);
		Dog dogRoger = new Dog("Roger", "2", true);
			
		String dogFalcoStr = dogToSerialize(dogFalco);
		String dogRogerStr = dogToSerialize(dogRoger);
		
		Dog dog = serializeToDog(dogFalcoStr);
		
		List<Dog> dogs = new ArrayList<>();
		dogs.add(dogFalco);
		dogs.add(dogRoger);
		
		String dogListStr = dogListToSerialize(dogs);
		
		List<Dog> deserializeDogs = serializeToDogList(dogListStr);
		
		// Print results.
		System.out.println(dogFalcoStr);
		System.out.println(dogRogerStr);
		System.out.println(dog.getDname() + " - " + dog.getDage());
		System.out.println(dogListStr);
		
		int cont = 0;
		for(Dog dogLoop : deserializeDogs) {
			cont ++;
			System.out.println(cont + ": " + dogLoop.getDname());
		}
		
		// Custoized mapping.
		JsonbConfig nillableConfig = new JsonbConfig().withNullValues(true);
		Jsonb jsonb = JsonbBuilder.create(nillableConfig);
		
		Dog pojo = new Dog("Dan", null, false);
		
		String result = jsonb.toJson(pojo);
		System.out.println("Result: " + result);
		
	}
	
	// Dog to JSON.
	public static String dogToSerialize(Dog dog) {
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(dog);
		return result;
	}
	
	// List to JSON.
	public static String dogListToSerialize(List<Dog> dogs) {
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(dogs);
		return result;
	}
	
	// JSON to Dog.
	public static Dog serializeToDog(String jsonResult) {
		Jsonb jsonb = JsonbBuilder.create();
		Dog dogResult = jsonb.fromJson(jsonResult, Dog.class);
		return dogResult;
	}
	
	// JSON to List.
	public static List<Dog> serializeToDogList(String jsonResult) {
		Jsonb jsonb = JsonbBuilder.create();
		List<Dog> dogListResult = jsonb.fromJson(jsonResult, new ArrayList<Dog>(){}.getClass().getGenericSuperclass());
		return dogListResult;
	}

}
