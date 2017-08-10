Feature: Login

Background:
	Given user initiate the driver

@First
Scenario Outline: Login functionality exists
	Given User navigates to qawebmail
	When user logs in using Username <username> and Password <password>
	Then Login is successful


	
@First		
Examples:
|username|password|                        
|mohdkamran|Farhan@1710|



@Second
Scenario: Logout
	Given user clicks compose button
	When user will edit message
	When user will click send button
	Then message is send