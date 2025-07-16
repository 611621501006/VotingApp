package com.voting.VotingApp.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class vote {

	private Long pollId;
	private int optionIndex;
}
