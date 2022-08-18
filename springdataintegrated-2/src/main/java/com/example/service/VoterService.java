package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.dto.VoterDTO;
import com.example.exception.VotingException;


public interface VoterService {

	public void addVoter(VoterDTO voter,Integer candidateId) throws VotingException;
	public VoterDTO getVoter(Integer voterId) throws VotingException;
	public List<VoterDTO> findAll() throws VotingException;
	public void deleteVoter(Integer voterId)throws VotingException;

}
