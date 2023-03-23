package com.example.demo.service;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String ResourceName;
	private String FieldName;
	private Object FieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super();
		ResourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
		System.out.println(ResourceName +"was not found:"+" " + FieldName + FieldValue);
	}
	public String getResourceName() {
		return ResourceName;
	}
	
	public String getFieldName() {
		return FieldName;
	}
	
	public Object getFieldValue() {
		return FieldValue;
	}
	
	

}
