package com.leader.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leader.main.entity.TeamLeader;


public interface TeamLeaderRepository extends JpaRepository<TeamLeader, Integer> {


	@Query("from TeamLeader t where t.tId=:tId")
	public TeamLeader getTeamLeaderbytId(@Param(value="tId")Integer tId );

}
