package com.voting.VotingApp.service;

import org.springframework.stereotype.Service;
import com.voting.VotingApp.model.poll;
import com.voting.VotingApp.repo.PollRepo;

@Service
public class PollService {

	public PollRepo pollRepo;

	public PollService(PollRepo pollRepo) {
		super();
		this.pollRepo = pollRepo;
	}

	public poll createPoll(poll poll) {

		return pollRepo.save(poll);
	}

}
