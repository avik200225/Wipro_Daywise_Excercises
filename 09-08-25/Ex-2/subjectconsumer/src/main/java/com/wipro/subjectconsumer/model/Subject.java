package com.wipro.subjectconsumer.model;

public class Subject {
	String subjectCode;
	String subject;
	
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subject=" + subject + "]";
	}
	
	
}