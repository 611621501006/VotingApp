package com.voting.VotingApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.voting.VotingApp.model.OptionVotes;
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

	public List<poll> getAllpoll() {

		return pollRepo.findAll();
	}

	public Optional<poll> getpollbyID(Long id) {

		return pollRepo.findById(id);
	}

	public void vote(Long pollId, int optionIndex) {
//		Get poll from DB
		poll poll = pollRepo.findById(pollId)
				.orElseThrow(() -> new RuntimeException("poll not found"));
		
//       Get All options
		List<OptionVotes> options = poll.getOptions();
		
//		If index for vote is not valid ,throw error
		if (optionIndex < 0 || optionIndex >= options.size()) {
			throw new IllegalArgumentException("Invalid option index");
		}
		
//		Get selected Option
		OptionVotes selectedOption = options.get(optionIndex);
		
//		Increment vote for selected option
		selectedOption.setVotecount(selectedOption.getVotecount() + 1);
		
//		save incremented option into the database
		pollRepo.save(poll); 
	}

}
