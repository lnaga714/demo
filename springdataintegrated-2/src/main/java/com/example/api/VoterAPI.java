package com.example.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.VoterDTO;
import com.example.exception.VotingException;
import com.example.service.VoterService;

// http://localhost:7777/country
@RestController
@RequestMapping("/country")
public class VoterAPI {

	
	@Autowired
	private VoterService voterService;

	@Autowired
	private Environment environment;

	// GET--->// http://localhost:7777/country/voters/1

	@GetMapping("/voters/{id}")
	public ResponseEntity<VoterDTO> getVoter(@PathVariable("id") int voterId) throws VotingException {

		VoterDTO voterDTO = voterService.getVoter(voterId);
		return new ResponseEntity<>(voterDTO, HttpStatus.OK);

	}
	// POST--->// http://localhost:7777/country/voters/111

	@PostMapping("/voters/{candidateId}")
	public ResponseEntity<String> addVoter(@RequestBody VoterDTO voterDTO,@PathVariable Integer candidateId) throws VotingException {
		voterService.addVoter(voterDTO, candidateId);
		String message = environment.getProperty("Controller.INSERT_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

// DELETE-----> http://localhost:7777/country/voters/4     
	@DeleteMapping("/voters/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int voterId) throws VotingException {
		voterService.deleteVoter(voterId);
		String message = environment.getProperty("Controller.DELETE_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}


	// GET------->// http://localhost:7777/country/voters
	@GetMapping("/voters")
	public ResponseEntity<List<VoterDTO>> getVoters() throws VotingException {
		List<VoterDTO> voterDTOList = voterService.findAll();
		return new ResponseEntity<>(voterDTOList, HttpStatus.OK);
	}

	
	
	

}
