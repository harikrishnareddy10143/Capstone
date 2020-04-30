package com.cts.capstrone.FeedbackManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import reactor.core.publisher.Mono;
@Entity
@Table(name="Dashboard")
public class Dashboard {
@Id
private int count;
@Column(name="totalVolunteers")
private int totalVolunteers;

@Column(name="livesImpacted")
private int livesImpacted;

@Column(name="totalParticipants")
private int totalParticipants;
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getTotalVolunteers() {
	return totalVolunteers;
}
public void setTotalVolunteers(int totalVolunteers) {
	this.totalVolunteers = totalVolunteers;
}
public int getLivesImpacted() {
	return livesImpacted;
}
public void setLivesImpacted(int livesImpacted) {
	this.livesImpacted = livesImpacted;
}
public int getTotalParticipants() {
	return totalParticipants;
}
public void setTotalParticipants(int totalParticipants) {
	this.totalParticipants = totalParticipants;
}




}
