package com.vti.dto;

import java.util.List;

public class Project {
	private int id;
	private String name;
	private int size;
	private Leader leader;
	private List<Member> members;

	public Project(int id) {
		super();
		this.id = id;
	}

	public Project(String name, int size, Leader leader, List<Member> members) {
		super();
		this.name = name;
		this.size = size;
		this.leader = leader;
		this.members = members;
	}

	public Project(int id, String name, int size, Leader leader) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.leader = leader;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Leader getLeader() {
		return leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", size=" + size + ", leader=" + leader + "]";
	}

}
