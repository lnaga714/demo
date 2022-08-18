package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.CandidateDTO;
import com.example.dto.VoterDTO;
import com.example.entity.Voter;
import com.example.exception.VotingException;
import com.example.repository.CandidateRepository;
import com.example.repository.VoterRepository;
import com.example.service.VoterServiceImpl;

@SpringBootTest
class Springdataintegrated2ApplicationTests {

	@Mock
	private VoterRepository voterRepository;

	@Mock
	private CandidateRepository candidateRepository;
	@InjectMocks
	private VoterServiceImpl voterServiceImpl = new VoterServiceImpl();

	@Test
	void addVoteInvalidCandidateTest() {
		int candidateId = 111;
		Optional optional = Optional.empty();
		VoterDTO voterDTO = new VoterDTO();
		voterDTO.setVoterId(1);
		voterDTO.setName("John");
		voterDTO.setDateOfBirth(LocalDate.now());
		CandidateDTO candidateDTO = new CandidateDTO();
		candidateDTO.setId(candidateId);
		candidateDTO.setName("E");
		candidateDTO.setNumberOfVotes(12000);
		voterDTO.setCandidate(candidateDTO);
		Mockito.when(candidateRepository.findById(candidateId)).thenReturn(optional);
		VotingException exception = Assertions.assertThrows(VotingException.class,
				() -> voterServiceImpl.addVoter(voterDTO, candidateId));
		Assertions.assertEquals("Service.CANDIDATE_NOT_FOUND", exception.getMessage());
	}

	@Test
	void getVoterInvalidVoterTest() {
		int voterId = 0;
		Optional optional = Optional.empty();
		Mockito.when(voterRepository.findById(voterId)).thenReturn(optional);
		VotingException exception = Assertions.assertThrows(VotingException.class,
				() -> voterServiceImpl.getVoter(voterId));
		Assertions.assertEquals("Service.VOTER_NOT_FOUND", exception.getMessage());
	}
	
	@Test
	void findAllInvalidTest() {
		Iterable<Voter>voterList=new ArrayList<>();
		Mockito.when(voterRepository.findAll()).thenReturn(voterList);
		VotingException exception = Assertions.assertThrows(VotingException.class,
				() -> voterServiceImpl.findAll());
		Assertions.assertEquals("Service.VOTERS_NOT_FOUND", exception.getMessage());
	}

	@Test
	void deleteVoterInvalidTest() {
		int voterId = 0;
		Optional optional = Optional.empty();
		Mockito.when(voterRepository.findById(voterId)).thenReturn(optional);
		VotingException exception = Assertions.assertThrows(VotingException.class,
				() -> voterServiceImpl.deleteVoter(voterId));
		Assertions.assertEquals("Service.VOTER_NOT_FOUND", exception.getMessage());
	}

}
