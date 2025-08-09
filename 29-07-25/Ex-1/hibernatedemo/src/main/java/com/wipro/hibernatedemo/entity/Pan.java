package com.wipro.hibernatedemo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pan")
public class Pan{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;	
	@Column(name="panholder_name")
	String panHolderName;	
	@Column(name="pan_number")
	String panNumber;

	public Pan() {
		super();
	}

	public Pan(String panHolderName, String panNumber) {
		super();
		this.panHolderName = panHolderName;
		this.panNumber = panNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanHolderName() {
		return panHolderName;
	}

	public void setPanHolderName(String panHolderName) {
		this.panHolderName = panHolderName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "Pan [id=" + id + ", panHolderName=" + panHolderName + ", panNumber=" + panNumber + "]";
	}
}
