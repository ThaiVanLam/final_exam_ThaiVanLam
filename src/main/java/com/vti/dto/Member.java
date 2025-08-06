package com.vti.dto;

public class Member extends User {
	private String skill;
	private Project project;

	public Member(int id, String fullname, String email, String password, String skill, Project project) {
		super(id, fullname, email, password, "member");
		this.skill = skill;
		this.project = project;
	}

	public Member(int id, String fullname, String email, String skill, Project project) {
		super(id, fullname, email, "member");
		this.skill = skill;
		this.project = project;
	}

	public Member(int id, String fullname, String email, String password, String userType, String skill) {
		super(id, fullname, email, password, userType);
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Member [skill=" + skill + ", project=" + project + "]";
	}

}
