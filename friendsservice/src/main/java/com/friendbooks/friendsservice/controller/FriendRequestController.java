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
        service.addRequest(friendRequest);
        
    }

    @RequestMapping(method = RequestMethod.PUT, value="/friend/request/{userEmail}")
    public void acceptRequest(
            @RequestBody FriendRequest friendRequest,
            @PathVariable("userEmail") String fromMail)
    {
        // accept
        // reject
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public List getRequestFor(@PathVariable("userEmail") String userEmail)
    {
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/friend/{fromEmail}/with/{withEmail}")
    public void removeFriend(@PathVariable("fromEmail") String fromEmail,@PathVariable("withEmail") String  withEmail)
    {
        // delete relation
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/{userEmail}")
    @ResponseBody
    public List getFriendsFor(@PathVariable("userEmail") String useremail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/count/{userEmail}")
    @ResponseBody
    public String getFriendsCount(@PathVariable("userEmail") String UserEmail){
        return "10";
    }
    @RequestMapping(method = RequestMethod.GET, value="/friend/suggestions/{userEmail}")
    @ResponseBody
    public List getFriendSuggestionsFor(@PathVariable("userEmail") String UserEmail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/mutual/{userEmail}/and/{toEmail}")
    @ResponseBody
    public List getMutualFriends(@PathVariable("userEmail") String UserEmail)
    {
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }
}
