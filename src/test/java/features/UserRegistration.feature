Feature: User registration 
	i want to register to the web site.
	
	Scenario Outline: user can register 
	Given the user in the home page 
	When  i click on the register link 
	And  i entered "<firstname>","<lastname>","<email>","<password>" 
	Then  i can register to the web site 
	
Examples:
		 |firstname|lastname|email|password
     |ahmad|hamdy|rr2r12r1rr@rfrrr.com|123456789
     |ahmad|hamdy|rr12r12rr1r@rrrr.com|123456789
     |ahmad|hamdy|r21rrr12rr4@rfrrr.com|123456789
     |ahmad|hamdy|rr12rrrdr@rrfrr.com|123456789
 
     

