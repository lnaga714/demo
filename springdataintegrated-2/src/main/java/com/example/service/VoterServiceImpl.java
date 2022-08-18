package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.CandidateDTO;
import com.example.dto.VoterDTO;
import com.example.entity.Candidate;
import com.example.entity.Voter;
import com.example.exception.VotingException;
import com.example.repository.CandidateRepository;
import com.example.repository.VoterRepository;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public void addVoter(VoterDTO voterDTO, Integer candidateId) throws VotingException {

		Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);
		Candidate candidate = optionalCandidate.orElseThrow(() -> new VotingException("Service.CANDIDATE_NOT_FOUND"));
		Voter voter = new Voter();
		voter.setName(voterDTO.getName());
		voter.setDateOfBirth(voterDTO.getDateOfBirth());
		voter.setCandidate(candidate);
		candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1); // The candidate's vote should be incremented by 1
		voterRepository.save(voter);

	}

	@Override
	public VoterDTO getVoter(Integer voterId) throws VotingException {

		Optional<Voter> voterOptional = voterRepository.findById(voterId);
		Voter voter = voterOptional.orElseThrow(() -> new VotingException("Service.VOTER_NOT_FOUND"));
		VoterDTO voterDTO = new VoterDTO();
		voterDTO.setVoterId(voter.getVoterId());
		voterDTO.setName(voter.getName());
		voterDTO.setDateOfBirth(voter.getDateOfBirth());
		//Candidate candidate = voter.getCandidate();
		CandidateDTO candidateDTO = new CandidateDTO();
		candidateDTO.setId(voter.getCandidate().getId());
		candidateDTO.setName(voter.getCandidate().getName());
		candidateDTO.setNumberOfVotes(voter.getCandidate().getNumberOfVotes());
		voterDTO.setCandidate(candidateDTO);
		
		return voterDTO;
	}

	@Override
	public void deleteVoter(Integer voterId) throws VotingException {
		Optional<Voter> voterOptional = voterRepository.findById(voterId);
		Voter voter = voterOptional.orElseThrow(() -> new VotingException("Service.VOTER_NOT_FOUND"));
		voter.setCandidate(null);
		voterRepository.deleteById(voterId);
	}

	@Override
	public List<VoterDTO> findAll() throws VotingException {
		List<VoterDTO> voterDTOList = new ArrayList<>();
		Iterable<Voter> voterList = voterRepository.findAll();
		voterList.forEach(voter -> {
			VoterDTO voterDTO = new VoterDTO();
			voterDTO.setVoterId(voter.getVoterId());
			voterDTO.setName(voter.getName());
			voterDTO.setDateOfBirth(voter.getDateOfBirth());
			Candidate candidate = voter.getCandidate();
			CandidateDTO candidateDTO = new CandidateDTO();
			candidateDTO.setId(candidate.getId());
			candidateDTO.setName(candidate.getName());
			candidateDTO.setNumberOfVotes(candidate.getNumberOfVotes());
			voterDTO.setCandidate(candidateDTO);
			voterDTOList.add(voterDTO);
		});
		if (voterDTOList.isEmpty()) {
			throw new VotingException("Service.VOTERS_NOT_FOUND");
		}

		return voterDTOList;
	}

}

