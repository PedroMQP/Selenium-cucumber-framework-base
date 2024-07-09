#Author: Pedro Manuel Quiroz Palacios
Feature: Search bar
	@Smoke
	 Scenario: Search
    Given I am on Home Page
    * I am not logged in
    When I search "<article>" on the search bar
    Then I will look one or more articles
    Examples:
    		|article|
				|lentes|
    		|sedfwetrewrgfwr|