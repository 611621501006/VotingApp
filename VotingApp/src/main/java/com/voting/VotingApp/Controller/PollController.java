package com.voting.VotingApp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voting.VotingApp.model.poll;
import com.voting.VotingApp.service.PollService;

@RestController
@RequestMapping("/api/polls")
public class PollController {

	private PollService pollService;

	public PollController(PollService pollService) {
		super();
		this.pollService = pollService;
	}

	@PostMapping
	public poll createPoll(@RequestBody poll poll) {
		return pollService.createPoll(poll);
	}
}
