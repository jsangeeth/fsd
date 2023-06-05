package com.leader.main.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leader.main.entity.TeamLeader;
import com.leader.main.service.TeamLeaderService;

@RestController
@RequestMapping("/TeamLeader")
public class TeamLeaderController {
	
	@Autowired
	TeamLeaderService teamLeaderService;
	
	@GetMapping("/")
	public String defaultMessage() {
		return "welcome to TeamLeader Page";
	}

	@PostMapping("/registerTeamLeader")
	public TeamLeader addTeamLeader(@RequestBody TeamLeader teamLeader) {
		try {
			return teamLeaderService.addTeamLeader(teamLeader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamLeader;
	}
}
