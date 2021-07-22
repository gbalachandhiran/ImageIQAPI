package com.controllers;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.json.JsonObject;
import org.bson.types.Binary;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.documents.Dicom;

@RestController
public class ImageIQController {
	
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	@PostMapping("/retreive")
	
	public String retreiveAndStoreData()
	{
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is("0c5c4388-78d5-49ae-a0ab-f06f59327b19"));
		
		Dicom document = mongoTemplate.findOne(query,Dicom.class);
		Binary file = document.getDicomfile();
		// DicomObject obj = 
		InputStream is = new ByteArrayInputStream(file.getData());
		
		
		
		
//		DicomInputStream din = new DicomInputStream(is.);
		
		
		return null;
	}
	
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("data")String data)
	{
		
		
		System.out.println(file);
		
		JSONObject json = new JSONObject(data);
		
		String sessionId = "";
		
		  try {
		
		UUID idOne = UUID.randomUUID();
		 sessionId = idOne.toString();
		 Dicom obj  =  new Dicom();
		 obj.setId(sessionId);
		 obj.setPatientId(json.getString("pid"));
		 obj.setSex(json.getString("sex"));
	// obj.setStudies(json.getString("studies"));
		 //obj.setDate(json.getString("date"));
		 obj.setSeqId(json.getString("seqId"));
		 obj.setModality(json.getString("modality"));
		 obj.setDicomfile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		 mongoTemplate.insert(obj);
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		 
		  }
		  catch (Exception e) {
		        e.printStackTrace();
		        return "failure";
		    }
		
		return sessionId;
		
	}

}
