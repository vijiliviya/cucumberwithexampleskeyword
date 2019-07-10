Feature: Free CRM Create Contacts 

Scenario Outline: Free CRM Create a new contact scenario 
	Given On Home Page 
	When User try to Navigate to LogIn Page 
	Then user enters "<username>" and "<password>" 
	Then User moves to new contact page
	Then user check the contact already available "<firstname>" and "<lastname>" 
	Then user enters contact details "<firstname>" and "<lastname>" and "<position>" 
	Then Close the browser 
	
	Examples: 
		| username                  | password   | firstname  | lastname | position         |
		| vijayalakshmiraja88@gmail.com      | jesus@123 | viji 	  | Hari    | QA analyst|
		| mmkstarone@gmail.com      | 578722@Ory | Mani 	  | Mohan    | Developer        |
		| neelamvermamsc@gmail.com  | Siya@123   | Neelam 	  | Verma    | Senior Developer |	
		