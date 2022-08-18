package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate,Integer> {

}
