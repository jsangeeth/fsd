package com.leader.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
