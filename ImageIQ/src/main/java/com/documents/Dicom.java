package com.documents;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Dicom {
	
	

    @Field
    private String id;
    
    
    @Field
    private Binary dicomfile;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Binary getDicomfile() {
		return dicomfile;
	}


	public void setDicomfile(Binary dicomfile) {
		this.dicomfile = dicomfile;
	}
    
    
    
    

}
