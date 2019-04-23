package com.friendbooks.friendsservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FriendRequestController {
	 @RequestMapping(method = RequestMethod.GET, value="/friend/request/{userEmail}")
    @ResponseBody
    public String getFriend(@PathVariable("userEmail") String userEmail) {
        return "Welcome "+userEmail;
    }
}
