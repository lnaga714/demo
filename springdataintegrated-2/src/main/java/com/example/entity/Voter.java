package com.example.entity;

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

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voterId;
	@Column(name = "votername", length = 20, nullable = false)
	private String name;
	private LocalDate dateOfBirth;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

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
		Voter other = (Voter) obj;
		return Objects.equals(candidate, other.candidate) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(name, other.name) && Objects.equals(voterId, other.voterId);
	}

	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", candidate="
				+ candidate + "]";
	}

}
