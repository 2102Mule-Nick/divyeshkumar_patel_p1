package com.freelancer.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.freelancer.pojo.Bids;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	private Queue exampleQueue;
	private Topic topic;
	private Queue bidQueue;

	/*
	 * @Autowired public void setJmsTemplate(JmsTemplate jmsTemplate) {
	 * this.jmsTemplate = jmsTemplate; }
	 */

	@Autowired
	@Qualifier("destinationQueue")
	public void setExampleQueue(Queue exampleQueue) {
		this.exampleQueue = exampleQueue;
	}

	@Autowired
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Autowired
	public void setBidQueue(Queue bidQueue) {
		this.bidQueue = bidQueue;
	}
	
	public void simpleSend(String msg) {
		jmsTemplate.send(topic,(s) -> s.createTextMessage(msg));
	}
	
	public void sendToBidQueue(Bids bids) {
		jmsTemplate.send(bidQueue, (s) -> s.createObjectMessage());
	}

}
