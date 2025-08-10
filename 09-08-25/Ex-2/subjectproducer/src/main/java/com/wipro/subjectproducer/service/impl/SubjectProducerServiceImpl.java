package com.wipro.subjectproducer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.subjectproducer.service.SubjectProducerService;

@Service
public class SubjectProducerServiceImpl implements SubjectProducerService{
	
	@Autowired
	KafkaTemplate<String,String> kafkTemplate;

	@Override
	public void sendSubjectData(String subjectCode, String subject) {
		kafkTemplate.send("learn-subject",subject);
		
	}

}
