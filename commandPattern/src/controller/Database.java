package controller;
import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<String, String> data;
	private String id;
	
	public Database(String id) {
		this.data = new HashMap<>();
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public void add(String key, String value) {
		if (data.containsKey(key)) {
			System.out.println("Cannot add a record for a key that already exists");
		} else {
			data.put(key, value);
		}
	}
	
	public String get(String key) {
		return data.get(key);
	}
	
	public void update(String key, String value) {
		if (data.containsKey(key)) {
			data.put(key, value);
		} else {
			System.out.println("Cannot update a key that doesn't exist");
		}
	}
	
	public void remove(String key) {
		if (data.containsKey(key)) {
			data.remove(key);
		} else {
			System.out.println("Cannot remove a key that doesn't exist");
		}
	}
	
	public void display() {
		for (Map.Entry<String, String> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "|" + entry.getValue());
		}
	}
}
