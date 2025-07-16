package com.voting.VotingApp.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//	create API 
	@PostMapping
	public poll createPoll(@RequestBody poll poll) {
		return pollService.createPoll(poll);
	}
	
//  get all data 
	@GetMapping
	public List<poll> getAllpoll()
	{
		return pollService.getAllpoll();
	}
	
//	get poll by ID
	@GetMapping("{id}")
	public ResponseEntity<poll> getpollbyId(@PathVariable Long id)
	{
		return pollService.getpollbyID(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/vote")
	public void vote(@RequestBody com.voting.VotingApp.request.vote vote)
	{
	    pollService.vote(vote.getPollId() , vote.getOptionIndex());
	}
 }
