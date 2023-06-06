package com.leader.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.exception.NullEmailFoundException;
import com.leader.main.exception.NullUserFound;
import com.leader.main.entity.TeamLeader;
import com.leader.main.repository.TeamLeaderRepository;

@Service
public class TeamLeaderServiceImpl implements TeamLeaderService{

	@Autowired
	TeamLeaderRepository teamLeaderRepository;
	@Override
	public TeamLeader addTeamLeader(TeamLeader teamLeader) throws Exception {

		return teamLeaderRepository.save(teamLeader);
	}
	
	

	@Override
	public TeamLeader registerTeamLeader(TeamLeader teamLeader) throws NullUserFound, NullEmailFoundException {

		if (teamLeader.getEmail() == null || teamLeader.getEmail() == "") {
			throw new NullEmailFoundException("Email id cannot be null");
		}

		else if (teamLeader.getFirstName().isEmpty() || teamLeader.getLastName().isEmpty()
				|| teamLeader.getEmail().isEmpty() || teamLeader.getPassword().isEmpty()) {
			throw new NullUserFound("Error: Null value is not accepted.");
		} else if (teamLeader.getFirstName().equals("string") || teamLeader.getLastName().equals("string")
				|| teamLeader.getPassword().equals("string") || teamLeader.getEmail().equals("string")) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		return teamLeaderRepository.save(teamLeader);
	}

	@Override
	public List<TeamLeader> getAllTeamLeader() {
		return teamLeaderRepository.findAll();
	}

	@Override
	public TeamLeader getTeamLeaderById(Integer id) throws InvalidUserId {
		if (id == 0) {
			throw new InvalidUserId("Null value is not excepted");
		}

		return teamLeaderRepository.getTeamLeaderbytId(id);
	}

	@Override
	public TeamLeader updateTeamLeader(TeamLeader teamLeader) throws  InvalidUserId {
		TeamLeader tl = getTeamLeaderById(teamLeader.gettId());

		if (tl == null) {
			throw new InvalidUserId("No TeamLeader Exixts with same this id: " + teamLeader.gettId());
		}

		return teamLeaderRepository.save(teamLeader);
	}

	

	@Override
	public void delete(int tId) throws InvalidUserId {

		teamLeaderRepository.deleteById(tId);
	}
	@Override
	public TeamLeader loginTeamLeader(String email, String password) throws InvalidCredentialsException {
		if (email.equals("") || email.equals("string") || password.equals("") || password.equals("string")) {
			throw new InvalidCredentialsException("Email or Password Cannot be empty");
		}

		TeamLeader tl = teamLeaderRepository.findTeamLeaderByEmailPassword(email, password);

		if (tl == null) {
			throw new InvalidCredentialsException("Cant Login tutor Email and Password dont match");
		}

		return tl;
	}

	
}
