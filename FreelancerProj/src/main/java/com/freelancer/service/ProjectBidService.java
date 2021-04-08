package com.freelancer.service;

import java.util.List;

import com.freelancer.pojo.Bids;
import com.freelancer.pojo.Project;
import com.freelancer.pojo.User;

public interface ProjectBidService {

	//public Bids addP(Project project,User user,int amount, String message);
	
	public Bids createBid(Bids bids);
	
	public Bids getBidByID(int id);
	
	public List<Bids> getAllBids();
	
	public void deleteBid(int id);
	
	public void updateBid(Bids bid);
}
