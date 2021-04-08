package com.freelancer.dao;

import java.util.List;

import com.freelancer.pojo.Bids;
import com.freelancer.pojo.Project;

public interface BidsDao {

	public Bids createBid(Bids bids);
	
	public Bids getBidByID(int id);
	
	public void removeBid(int id);
	
	public void updateCart(Bids bids);
	
	public Bids addProjectToBid(Bids bids,Project project,int amt, String message);
	
	public List<Bids> getAllBids();
	
	
}
