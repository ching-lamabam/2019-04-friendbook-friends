package com.friendbooks.friendsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbooks.friendsservice.dao.FriendDAO;
import com.friendbooks.friendsservice.dto.FriendRequest;
import com.friendbooks.friendsservice.entity.FriendEntity;

@Service
public class FriendRequestService {

	@Autowired
	FriendDAO friendDAO;

	public void addRequest(FriendRequest friendRequest) {
		FriendEntity entity = new FriendEntity();
		entity.setFromEmail(friendRequest.getFromEmail());
		entity.setToEmail(friendRequest.getToEmail());
		entity.setStatus("Pending");
        friendDAO.save(entity);		
	}
	
	
	
}
