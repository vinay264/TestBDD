Feature: Automated End2End Tests
Description: The purpose of this feature is to test End 2 End integration.
 
@End2End_1
Scenario Outline: Customer place an order by purchasing an item from search	
	Given user is on Home Page
	When user searches for "dress"
	When user chooses to buy the item 1 with color as "White" and size as "Medium"
	When user moves to checkout from mini cart
	When user enters "<customer>" personal details on checkout page
	When user accepts terms and conditions
	Then place the order
	Then verify the order details
	Then take screenshot of order
	
Examples:
	|customer|
	|Lakshay|
	|Virender|