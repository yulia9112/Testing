@calculator
Feature: Mul
	As a math idiot
	I want to be told the mul of two numbers
	So that I can avoid silly mistakes

@positive @sprint3
Scenario: Multiply two numbers
	Given I have entered first number 50.0 into the calculator
	And I have entered second number 70.0 into the calculator
	When I press multiply
	Then the result should be 3500.0 on the screen
