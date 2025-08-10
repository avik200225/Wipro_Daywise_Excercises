package com.wipro.subjectproducer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.subjectproducer.model.Subject;
import com.wipro.subjectproducer.service.SubjectProducerService;


@Service
public class SubjectProducerServiceImpl implements SubjectProducerService {
	
	@Autowired
	KafkaTemplate<String, Subject> kafkaTemplate;

	@Override
	public void sendSubjectData(Subject subject) {
		
		kafkaTemplate.send("learn-subject", subject);

	}

}
