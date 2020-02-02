Feature: Testing invalid mail formats
  As a qa
  I want to check positive and negative cases regarding with login

  Background:
    Given The system shows "SCREENPLOYEEREGISTER" page

 ###################Idea for nextAdditional test TODO
  Scenario: Checking Birthday format with strings
    When I choose to "logged in" with a "<UserName>" and "<Email>"
    And I "logged in" and the system shows "SCREENPLOYEEPAGE"
    And I edit employee "snezni"
    And I change "Birthday" attribute with "string/string/string"
    Then Error message "Date format is not valid" displays



  Scenario: Checking Birthday format with invalid month and year format
    When I choose to "logged in" with a "<UserName>" and "<Email>"
    And I "logged in" and the system shows "SCREENPLOYEEPAGE"
    And I edit employee "snezni"
    And I change "Birthday" attribute with "99/99/99"
    Then Error message "Date format is not valid" displays



  Scenario: Checking Birthday format with digit length
    When I choose to "logged in" with a "<UserName>" and "<Email>"
    And I "logged in" and the system shows "SCREENPLOYEEPAGE"
    And I edit employee "snezni"
    And I change "Birthday" attribute with "11111/11111/1111111"
    Then Error message "Date format is not valid" displays







