package com.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.dao.BidsDao;
import com.freelancer.messaging.JmsMessageSender;
import com.freelancer.pojo.Bids;

@Service
public class ProjectBidServiceImpl implements ProjectBidService {

	private BidsDao bidsDao;

	private JmsMessageSender messageSender;

	@Autowired
	public void setBidsDao(BidsDao bidsDao) {
		this.bidsDao = bidsDao;
	}

	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Override
	@Transactional
	public Bids createBid(Bids bids) {
		messageSender.sendToBidQueue(bids);
		
		return null;
	}

	@Override
	public Bids getBidByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bids> getAllBids() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBid(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBid(Bids bid) {
		// TODO Auto-generated method stub

	}

}
