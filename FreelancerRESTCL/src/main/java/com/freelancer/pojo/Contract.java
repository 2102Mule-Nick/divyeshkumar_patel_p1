package com.freelancer.pojo;

public class Contract {
	
	private int contractId;
	
	private int bidId;
	
	private String approvedDate;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedDate == null) ? 0 : approvedDate.hashCode());
		result = prime * result + bidId;
		result = prime * result + contractId;
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
		Contract other = (Contract) obj;
		if (approvedDate == null) {
			if (other.approvedDate != null)
				return false;
		} else if (!approvedDate.equals(other.approvedDate))
			return false;
		if (bidId != other.bidId)
			return false;
		if (contractId != other.contractId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", bidId=" + bidId + ", approvedDate=" + approvedDate + "]";
	}

	public Contract(int contractId, int bidId, String approvedDate) {
		super();
		this.contractId = contractId;
		this.bidId = bidId;
		this.approvedDate = approvedDate;
	}

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
