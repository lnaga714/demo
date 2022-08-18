package com.example.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class VoterDTO {

	private Integer voterId;
    private String name;
	private LocalDate dateOfBirth;
	private CandidateDTO candidate;
	public Integer getVoterId() {
		return voterId;
	}
	public void setVoterId(Integer voterId) {
		this.voterId = voterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public CandidateDTO getCandidate() {
		return candidate;
	}
	public void setCandidate(CandidateDTO candidate) {
		this.candidate = candidate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(candidate, dateOfBirth, name, voterId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoterDTO other = (VoterDTO) obj;
		return Objects.equals(candidate, other.candidate) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(name, other.name) && Objects.equals(voterId, other.voterId);
	}
	@Override
	public String toString() {
		return "VoterDTO [voterId=" + voterId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", candidate="
				+ candidate + "]";
	}


}
