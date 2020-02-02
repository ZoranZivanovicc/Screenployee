@regression @list_of_employees
Feature: Testing employee list
  As a qa
  I want to check positive and negative cases regarding with login

  Background:
    Given The system shows "SCREENPLOYEELOGIN" page


 Scenario:Create a new employee
   When I choose to "logged in" with a "VALIDLOGINUSER" and "<Email>"
    And I "logged in" and the system shows "SCREENPLOYEEPAGE"
    And I create a new employee with "Zoran","zoran@gmail.com", "27/11/1970" data value
    Then I can see employee with a listed value
    When I delete employye
    Then I logged out






