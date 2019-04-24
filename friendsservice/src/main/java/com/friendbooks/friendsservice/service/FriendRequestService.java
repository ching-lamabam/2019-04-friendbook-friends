package com.friendbooks.friendsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.friendbooks.friendsservice.dao.FriendDAO;
import com.friendbooks.friendsservice.dto.FriendRequest;
import com.friendbooks.friendsservice.entity.FriendEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FriendRequestService {

	@Autowired
	FriendDAO friendDAO;

	public void addRequest(FriendRequest friendRequest) {
		// Plan for Failure 
		// 1 500 internal unplanned
		// 2 service taking long time
		// 3 service endpoint cannot be located
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

	public int getCount(String userEmail) {
		
		List<FriendEntity> allfriends = getAllFriends(userEmail);
		Set<FriendEntity> uniqueFriends = new HashSet<>(allfriends);
		return uniqueFriends.size();
	}

	public List<FriendEntity> getAllFriends(String userEmail) {
		List<FriendEntity> allfriends = friendDAO.findByFromEmail(userEmail);
		allfriends.addAll(allfriends);
		return allfriends;
	}

	public List getFriendSuggestionsFor(String userEmail) {
		Set<FriendEntity> friendSuggestions = new HashSet<>();
		for(FriendEntity friend :getAllFriends(userEmail)) {
			friendSuggestions.addAll(getAllFriends(friend.getToEmail()));
			friendSuggestions.addAll(getAllFriends(friend.getFromEmail()));
		}
		List<String> emails = 
				friendSuggestions.stream()
			              .map(FriendEntity::getFromEmail)
			              .collect(Collectors.toList());
		return emails;
	}
}
