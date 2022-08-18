package com.example.dto;

import java.util.Objects;





public class CandidateDTO {

private int id;
private String name;
private int numberOfVotes;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumberOfVotes() {
	return numberOfVotes;
}
public void setNumberOfVotes(int numberOfVotes) {
	this.numberOfVotes = numberOfVotes;
}
@Override
public int hashCode() {
	return Objects.hash(id, name, numberOfVotes);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CandidateDTO other = (CandidateDTO) obj;
	return id == other.id && Objects.equals(name, other.name) && numberOfVotes == other.numberOfVotes;
}
@Override
public String toString() {
	return "Candidate [id=" + id + ", name=" + name + ", numberOfVotes=" + numberOfVotes + "]";
}


}