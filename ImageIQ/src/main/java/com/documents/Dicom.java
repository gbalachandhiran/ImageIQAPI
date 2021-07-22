package com.documents;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Dicom {
	
	

    @Field
    private String id;
    
    
    
    @Field
    private String seqId;
    
    
    @Field
    private String patientId;
    
    
    @Field
    private String sex;
    
    
    @Field
    private String studies;
    
    
    @Field
    private String date;
    
    
    @Field
    private String modality;
    
    
    
    
    @Field
    private Binary dicomfile;


	


	public Binary getDicomfile() {
		return dicomfile;
	}


	public void setDicomfile(Binary dicomfile) {
		this.dicomfile = dicomfile;
	}


	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getSeqId() {
		return seqId;
	}


	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getStudies() {
		return studies;
	}


	public void setStudies(String studies) {
		this.studies = studies;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getModality() {
		return modality;
	}


	public void setModality(String modality) {
		this.modality = modality;
	}


	
    
    
    
    

}
