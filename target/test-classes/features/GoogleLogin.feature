Feature: Creating a bdd project with java
	Scenario: Login on Google with Failure
		When I navigate to google login page
		And I put the wrong user
		And Click on next button
		Then an error message should be displayed