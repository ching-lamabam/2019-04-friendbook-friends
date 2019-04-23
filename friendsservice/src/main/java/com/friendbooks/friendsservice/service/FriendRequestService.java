package com.friendbooks.friendsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.friendbooks.friendsservice.dao.FriendDAO;
import com.friendbooks.friendsservice.dto.FriendRequest;
import com.friendbooks.friendsservice.entity.FriendEntity;

import java.util.List;

@Service
public class FriendRequestService {

	@Autowired
	FriendDAO friendDAO;

	public void addRequest(FriendRequest friendRequest) {
		FriendEntity entity = new FriendEntity();
		entity.setFromEmail(friendRequest.getFromEmail());
		entity.setToEmail(friendRequest.getToEmail());
		entity.setStatus("pending");
        friendDAO.save(entity);		
	}
	
	public List<FriendEntity> getALlPendingRequest(){
        List<FriendEntity> pendingFriendRequest = friendDAO.findAllByStatus("pending");
        return pendingFriendRequest;
	}

    public FriendEntity update(FriendRequest friendRequest) {
        FriendEntity record = friendDAO.findByFromEmailAndToEmail(friendRequest.getFromEmail(),friendRequest.getToEmail());
	    record.setStatus(friendRequest.getStatus());
        return friendDAO.save(record);
    }

    public void delete(String fromEmail, String toEmail)
    {
        FriendEntity record = friendDAO.findByFromEmailAndToEmail(fromEmail, toEmail);
        friendDAO.delete(record);
    }
}
