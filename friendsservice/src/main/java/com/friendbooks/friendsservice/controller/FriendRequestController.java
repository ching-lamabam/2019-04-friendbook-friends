package com.friendbooks.friendsservice.controller;

import com.friendbooks.friendsservice.dto.FriendRequest;
import com.friendbooks.friendsservice.service.FriendRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FriendRequestController {

	@Autowired
	FriendRequestService service;
	
    @RequestMapping(method = RequestMethod.POST, value="/friend/request/{userEmail}")
    @ResponseBody
    public void addRequest(
            @RequestBody FriendRequest friendRequest,
            @PathVariable("userEmail") String userEmail )
    {
        friendRequest.setFromEmail(userEmail);
        friendRequest.setStatus("pending");
        service.addRequest(friendRequest);
        
    }

    @RequestMapping(method = RequestMethod.PUT, value="/friend/request/{userEmail}")
    @ResponseBody
    public void acceptRequest(
            @RequestBody FriendRequest friendRequest,
            @PathVariable("userEmail") String userEmail)
    {
        // accept
        // reject
        friendRequest.setFromEmail(userEmail);
        service.update(friendRequest);

    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public List getRequestFor(@PathVariable("userEmail") String userEmail)
    {
        return service.getALlPendingRequest();
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/friend/{fromEmail}/with/{withEmail}")
    @ResponseBody
    public void removeFriend(@PathVariable("fromEmail") String fromEmail,
                             @PathVariable("withEmail") String  withEmail)
    {
        // delete relation
        service.delete(fromEmail,withEmail);
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/{userEmail}")
    @ResponseBody
    public List getFriendsFor(@PathVariable("userEmail") String useremail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/count/{userEmail}")
    @ResponseBody
    public int getFriendsCount(@PathVariable("userEmail") String UserEmail){
        return service.getCount(UserEmail);
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/suggestions/{userEmail}")
    @ResponseBody
    public List getFriendSuggestionsFor(@PathVariable("userEmail") String UserEmail){
        
        return service.getFriendSuggestionsFor(UserEmail);
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/mutual/{userEmail}/and/{toEmail}")
    @ResponseBody
    public List getMutualFriends(@PathVariable("userEmail") String UserEmail)
    {
        //return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    	return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }
}
