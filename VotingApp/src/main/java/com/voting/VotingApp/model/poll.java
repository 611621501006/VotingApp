package com.voting.VotingApp.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class poll {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String question;
	
	
	@ElementCollection
	private List<OptionVotes> options = new ArrayList<>();
	
//	@ElementCollection
//	private List<Long> votes = new ArrayList<>();
	
}
