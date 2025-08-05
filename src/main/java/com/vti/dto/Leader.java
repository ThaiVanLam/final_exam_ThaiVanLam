package com.vti.dto;

public class Leader extends User {
	private int numberOfProject;

	public Leader(int id, String fullname, String email, String password, int numberOfProject) {
		super(id, fullname, email, password, "leader");
		this.numberOfProject = numberOfProject;
	}

	public Leader(String fullname, String email, String password, String userType, int numberOfProject) {
		super(fullname, email, password, userType);
		this.numberOfProject = numberOfProject;
	}

	public int getNumberOfProject() {
		return numberOfProject;
	}

	public void setNumberOfProject(int numberOfProject) {
		this.numberOfProject = numberOfProject;
	}

	@Override
	public String toString() {
		return "Leader [numberOfProject=" + numberOfProject + "]";
	}

}
