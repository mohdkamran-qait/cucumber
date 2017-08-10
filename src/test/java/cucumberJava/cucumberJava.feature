Feature: Login
Scenario Outline: Login functionality exists
	Given User navigates to qawebmail
	When user logs in using Username <username> and Password <password>
	Then Login is successful	
Examples:
|username|password|                        
|mohdkamran|Farhan@1710|