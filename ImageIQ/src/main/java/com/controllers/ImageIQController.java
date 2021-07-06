package com.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.documents.Dicom;
import com.documents.HackathonDocument;

@RestController
public class ImageIQController {
	
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	@PostMapping("/retreive")
	public byte[] retreiveFile(@RequestParam("id") String id) throws IOException
	{
		
		
		
		
		
		Query query = new Query();
//		query.addCriteria(Criteria.where("id").is(id));
		List<Dicom> document = mongoTemplate.findAll(Dicom.class);
		Binary file = document.getDocument().getVideo_file();
		mongoTemplate.findAndRemove(query, HackathonDocument.class);
		return file.getData();
		
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file)
	{
		
		
		System.out.println(file);
		
		
		
		String sessionId = "";
		
		  try {
		
		UUID idOne = UUID.randomUUID();
		 sessionId = idOne.toString();
		 Dicom obj  =  new Dicom();
		 obj.setId(sessionId);
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
