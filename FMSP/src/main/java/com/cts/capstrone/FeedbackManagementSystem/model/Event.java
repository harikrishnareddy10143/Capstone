package com.cts.capstrone.FeedbackManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Event")
public class Event {
@Id
private Integer eventId;
@Column
private String eventName;
@Column
private String eventDate;
@Column
private String businessUnit;
@Column
private String venue;
@Column
private int totalVollunteers;
@Column
private int totalParticipants;
@Column
private int livesImpacted;
@Column
private int vallunteerHours;
@Column
private int travelHours;
public Integer getEventId() {
	return eventId;
}
public void setEventId(Integer eventId) {
	this.eventId = eventId;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getEventDate() {
	return eventDate;
}
public void setEventDate(String eventDate) {
	this.eventDate = eventDate;
}
public String getBusinessUnit() {
	return businessUnit;
}
public void setBusinessUnit(String businessUnit) {
	this.businessUnit = businessUnit;
}
public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}
public int getTotalVollunteers() {
	return totalVollunteers;
}
public void setTotalVollunteers(int totalVollunteers) {
	this.totalVollunteers = totalVollunteers;
}
public int getTotalParticipants() {
	return totalParticipants;
}
public void setTotalParticipants(int totalParticipants) {
	this.totalParticipants = totalParticipants;
}
public int getLivesImpacted() {
	return livesImpacted;
}
public void setLivesImpacted(int livesImpacted) {
	this.livesImpacted = livesImpacted;
}
public int getVallunteerHours() {
	return vallunteerHours;
}
public void setVallunteerHours(int vallunteerHours) {
	this.vallunteerHours = vallunteerHours;
}
public int getTravelHours() {
	return travelHours;
}
public void setTravelHours(int travelHours) {
	this.travelHours = travelHours;
}
@Override
public String toString() {
	return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", businessUnit="
			+ businessUnit + ", venue=" + venue + ", totalVollunteers=" + totalVollunteers + ", totalParticipants="
			+ totalParticipants + ", livesImpacted=" + livesImpacted + ", vallunteerHours=" + vallunteerHours
			+ ", travelHours=" + travelHours + "]";
}
public Event() {
	super();
}




}