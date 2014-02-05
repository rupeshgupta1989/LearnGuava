package com.learn.guava.example.basicutility;

import com.google.common.base.Objects;

/**
 * Objects is a helper class in Guava that can operate on any Object.
 * 
 * Objects makes it easy to implement hashcode/equals without cluttering your
 * classes too much.
 * 
 * Classes that implement toString are really pleasant to use when doing
 * debugging and logging, but can be a real pain to implement.
 * Objects.toStringHelper makes this really easy and also help maintaining a
 * consistent format for printing objects.
 * 
 * @author srimeda
 * 
 */
public class ObjectsExample {
	public static void main(String[] args) {
		Item i = new Item("1", "Srini");
		System.out.println(i);
	}
}

class Item {
	private String id;
	private String name;

	Item(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getName());
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Item)){
			return false;
		}
		Item other = (Item) obj;
		return Objects.equal(getId(), other.getId()) && Objects.equal(getName(), other.getName());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", getId()).add("name", getName()).toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
