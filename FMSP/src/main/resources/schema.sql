CREATE TABLE Event (
  eventId INT AUTO_INCREMENT  PRIMARY KEY,
  eventName VARCHAR(250),
  eventDate VARCHAR(250),
  businessUnit VARCHAR(250),
  venue VARCHAR(250),
  totalVollunteers numeric,
  vallunteerHours numeric,
  travelHours numeric
);