package com.wipro.subjectproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.subjectproducer.model.Subject;
import com.wipro.subjectproducer.service.SubjectProducerService;

@RestController
@RequestMapping("/learn")
public class SubjectProducerController {
	@Autowired
	SubjectProducerService subjectService;
	
//	@PostMapping
//	void sendSubjectData(@RequestParam String subjectCode,@RequestParam String subject)
//	{
//		subjectService.sendSubjectData(subjectCode, subject);
//	}
//	
	@PostMapping
	public void sendLearnSubjectData(@RequestBody Subject subject) {
		subjectService.sendSubjectData(subject);
	}

}
