package com.leader.main.service;

import org.springframework.stereotype.Service;

import com.leader.main.entity.TeamLeader;

@Service
public interface TeamLeaderService {

	public TeamLeader addTeamLeader(TeamLeader teamLeader) throws Exception;
}
