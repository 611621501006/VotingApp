package com.voting.VotingApp.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVotes {

	private String voteoption;
	private Long votecount = 0L;
}