# Sahaya Services

Sahaya is a customer support solution, for managing customer grievances.
It is built on springboot using java 11.

The following services are being built as of now. Additional details are mentioned below.

Service Group | URI | Description | Status
---------- | -------------------- | ---------- | ----
Employee | **/api/v1/user/register** | registering a new employee | Created
Employee | **/api/v1/user/authenticate** | Authentication of an employee for login | Created
Employee | **/api/v1/user/empId** | Returns employee id when supplied with email | Created
Employee | **/api/v1/user/creds** | Additional authentication questions will be sent back | Created
Employee | **/api/v1/user/updateDetails** | Updates provided details in request | Created
Ticket | **/api/v1/ticket/register** | Registering a new ticket | Created
Ticket | **/api/v1/ticket/update** | Updates existing ticket details | Created
Ticket | **/api/v1/ticket/active** | Returns all tickets other than closed status | Created
Ticket | **/api/v1/ticket/user/{userName}** | Tickets that are opened by a specific user | Created
Ticket | **/api/v1/ticket/emp/{empId}** | Tickets assigned to a user which are not closed | Created
Ticket | **/api/v1/ticket/user/message** | Added feedback for the ticket | Created

## Tech Stack
**Programming Language:** Java-11
**Framework:** Spring-Boot

## App Hosting
Will be hosted on Heroku

## Persistence of Data
As of now H2 implementation is being generated once the app building is completed.
The same will be hosted on Heroku with Heroku postgresql.

