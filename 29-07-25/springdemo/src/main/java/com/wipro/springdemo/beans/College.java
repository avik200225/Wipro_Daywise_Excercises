package com.wipro.springdemo.beans;

public class College {
    private String cllgName;
    private Department department;

    public College() {
        //System.out.println("College default constructor called");
    }
    
    public College(String cllgName, Department department) {
		super();
		this.cllgName = cllgName;
		this.department = department;
	}

	public String getCllgName() {
        return cllgName;
    }

    public void setCllgName(String cllgName) {
        this.cllgName = cllgName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "College [cllgName=" + cllgName + ", department=" + department + "]";
    }
}
