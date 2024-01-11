Feature: Search and place the order for products

@SearchNavTests
	Scenario Outline: Search experiance for product search in both home and offers page
		Given user is on the GreenCart landing  page
		When user serches with shortname <Name> and extracted actual name of product
		Then user searches for the same shortname <Name> on the offers page
		And validate product name on landing page and home page match

	Examples:
	| Name |
	| Tom  |
	| Str  |
#	| Bee  |