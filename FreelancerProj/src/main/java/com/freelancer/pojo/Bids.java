package com.freelancer.pojo;

import java.util.List;

public class Bids {

	private int bidId;
	private int projectId;
	private int userId;
	private int amount;
	private String message;
	
	private List<Project> projects;
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + bidId;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + projectId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bids other = (Bids) obj;
		if (amount != other.amount)
			return false;
		if (bidId != other.bidId)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (projectId != other.projectId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bids [bidId=" + bidId + ", projectId=" + projectId + ", userId=" + userId + ", amount=" + amount
				+ ", message=" + message + "]";
	}
	public Bids(int bidId, int projectId, int userId, int amount, String message) {
		super();
		this.bidId = bidId;
		this.projectId = projectId;
		this.userId = userId;
		this.amount = amount;
		this.message = message;
	}
	public Bids() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
