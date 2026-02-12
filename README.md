# Use custom user details instead of query DB in each API.
This is what happened at my work.

## Scenario
* A RESTful API service that will be called by Vue frontend service.
* Each API will query DB several times to get privilege data of logged-in account.
* Account privileges are used to validate authorization and seldom changed.

## The bad smell
* Each time an API is called, it queries the DB to get the same privilege data.
* There are about 30 APIs.
* If account privileges change, the system must log this account out for security reasons.

## The demo
* I simplified the bad smell problem to show where we can save account additional data in login flow. 
  * For example, the account email.
* [API spec](spring_security_user_details_demo-openapi.yaml)