
Feature: Testing register functionality
  As a qa
  I want to check positive and negative cases regarding with register

  Background:
    Given The system shows "SCREENPLOYEEREGISTER" page
  @jjjj
 Scenario Outline: Can register a new account

    When I choose to "register" with a user with "<RandomString>" and "<Email>"
    Then I "registered" and the system shows "SCREENPLOYEEPAGE"
    #Last step should be for clean up, to remove user from database or from the frontend side that this test can be executable each time

   Examples:
     | RandomString                              | Email          |
     | RANDOM_REGULAR_STRING                     | @acme.com  |
     | RANDOM_SPEC_CHAR_STRING                   | @acme.com      |
     | RANDOM_NUMBERS_STRING                     | @acme.com      |
     | RANDOM_STRINGS_AND_NUMBERS                | @acme.com      |


  Scenario Outline: Can't register a new account
    When I choose to register with a "<UserName>" and "<Email>"
    Then "<ErrorMessage>" displayed


    Examples:
      | UserName                                  | Email              |ErrorMessage                  |
      | VALIDREGISTERUSER                         |  ray@acme.com      | That e-mail already exists   |
      | VALIDREGISTERUSER                         | valid@acme.com     | That username already exists|
      | VALIDREGISTERUSER                         |                    | The email field cannot be left blank!|
      | VALIDREGISTERUSER                         |   d                | Email format should be this format xxxx@xxx.xxx|
      | INVALIDREGISTERUSER                       | valid@acme.com     | The password field cannot be left blank!|







