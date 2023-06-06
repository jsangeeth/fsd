package com.leader.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.exception.NullEmailFoundException;
import com.leader.main.exception.NullUserFound;
import com.leader.main.entity.TeamLeader;

@Service
public interface TeamLeaderService {

	public TeamLeader addTeamLeader(TeamLeader teamLeader) throws Exception;
	public TeamLeader registerTeamLeader(TeamLeader teamLeader) throws NullUserFound, NullEmailFoundException;

	public List<TeamLeader> getAllTeamLeader();
	

	public TeamLeader getTeamLeaderById(Integer id) throws InvalidUserId;

	public TeamLeader updateTeamLeader(TeamLeader teamLeader) throws InvalidUserId;

	
	
	public void delete(int tId) throws InvalidUserId;
	public TeamLeader loginTeamLeader(String email, String password) throws InvalidCredentialsException;
	
	

}
