package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Voter;

public interface VoterRepository extends CrudRepository<Voter, Integer> {
	
}
