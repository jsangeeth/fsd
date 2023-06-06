package com.leader.main.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leader.main.entity.TeamLeader;
import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.exception.NullEmailFoundException;
import com.leader.main.exception.NullUserFound;
import com.leader.main.service.TeamLeaderService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TeamLeader")
public class TeamLeaderController {
	
	@Autowired
	TeamLeaderService teamLeaderService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/")
	public String defaultMessage() {
		return "welcome to TeamLeader Page";
	}

	
	@PostMapping("/registerTeamLeader")
	public TeamLeader registerTeamLeader(@RequestBody TeamLeader teamLeader) throws NullUserFound,  NullEmailFoundException {
		
		mylogs.info("---->>>Inside Controller TI  :- " + teamLeader);

			return teamLeaderService.registerTeamLeader(teamLeader);
		
	}
	
	@GetMapping("/allTeamLeader")//localhost:7001/TeamLeader/allTeamLeader
	public List<TeamLeader> getAllTeamLeader(){
		return teamLeaderService.getAllTeamLeader();
	}

	@PutMapping("/updateTeamLeader")//localhost:7001/TeamLeader/updateTeamLeader
	public TeamLeader updateTeamLeader(@RequestBody TeamLeader teamLeader) throws InvalidUserId {
		return teamLeaderService.updateTeamLeader(teamLeader);
	}

	


	@DeleteMapping("/delete/{tId}") // localhost:7001/TeamLeader/delete/2
	public String deleteTeamLeaderById(@PathVariable int tId) throws InvalidUserId {

		try {
			teamLeaderService.delete(tId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "Deleted Id = " + tId + " Data";
	}
	@GetMapping("/loginTeamLeader/{email}/{password}")//localhost:7001/TeamLeader/loginTeamLeader/anu@gmail.com/vijju
	public TeamLeader loginTeamLeader(@PathVariable String email, @PathVariable String password) throws InvalidCredentialsException
	{
		return teamLeaderService.loginTeamLeader(email, password);
	}
	
}
