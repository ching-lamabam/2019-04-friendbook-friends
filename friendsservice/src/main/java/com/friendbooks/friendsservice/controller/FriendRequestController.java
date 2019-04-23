package com.friendbooks.friendsservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FriendRequestController {

//	@RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
//    @ResponseBody
//    public String getFriend(@PathVariable("userEmail") String userEmail) {
//
//	    return "Welcome "+userEmail;
//    }

    @RequestMapping(method = RequestMethod.POST, value="/friend/request/{userEmail}")
    @ResponseBody
    public void addRequest(@PathVariable("userEmail") String userEmail, @RequestParam("toEmail") String  toEmail){

    }

    @RequestMapping(method = RequestMethod.PUT, value="/friend/request/{userEmail}")
    public void acceptRequest(@PathVariable("userEmail") String fromMail){
        // accept
    }

    @RequestMapping(method = RequestMethod.PUT, value="/friend/request/{userEmail}")
    public void rejectRequestFrom(@PathVariable("userEmail") String fromEmail,@PathVariable("userEmail") String  toemail){
        // reject
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public List getRequestFor(@PathVariable("userEmail") String userEmail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/friend/{fromEmail}/with/{withEmail}")
    public void removeFriend(@PathVariable("fromEmail") String fromEmail,@PathVariable("withEmail") String  withEmail){
        // delete relation
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public List getFriendsFor(@PathVariable("userEmail") String useremail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/count/{userEmail}")
    @ResponseBody
    public String getFriendsCount(@PathVariable("userEmail") String UserEmail){
        return "10";
    }
    @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public String getFriendSuggestionsFor(@PathVariable("userEmail") String UserEmail){
        return "Welcome ";
    }

    @RequestMapping(method = RequestMethod.GET, value="/friend/mutual/{userEmail}/and/{toEmail}")
    @ResponseBody
    public List getMutualFriends(@PathVariable("userEmail") String UserEmail){
        return Arrays.asList(new String[]{"xyz@gmail.com", "abc@xmail.com"});
    }
}