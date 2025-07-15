package com.voting.VotingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voting.VotingApp.model.poll;

@Repository
public interface PollRepo extends JpaRepository<poll, Long>{

}
