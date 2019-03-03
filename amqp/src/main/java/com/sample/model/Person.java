package com.sample.model;

public class Person {
	
	private String id;
	
	private String name;
	
	private Integer age;
	
	private String title;

	public Person() {
		super();
	}

	public Person(String id, String name, Integer age, String title) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.title = title;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", title=" + title + "]";
	}

}
