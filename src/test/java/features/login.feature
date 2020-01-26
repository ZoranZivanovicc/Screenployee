Feature: Testing register functionality
  As a qa
  I want to check positive and negative cases regarding with login

  Background:
    Given The system shows "SCREENPLOYEELOGIN" page

 Scenario Outline: Can register a new account

    When I choose to "logged in" with a "<UserName>" and "<Email>"
    Then I "logged in" and the system shows "SCREENPLOYEEPAGE"


   Examples:
     | UserName              |
     | VALIDREGISTERUSER     |


  Scenario Outline: Can't login with an account
    When I choose to "logged in" with a "<UserName>" and "<Email>"
    Then "<ErrorMessage>" displayed


    Examples:
      | UserName                                  | Email              |ErrorMessage                  |
      | VALIDREGISTERUSER                         |  ray@acme.com      | That e-mail already exists   |
      | VALIDREGISTERUSER                         | valid@acme.com     | That username already exists|
      | VALIDREGISTERUSER                         |                    | The email field cannot be left blank!|
      | VALIDREGISTERUSER                         |   d                | Email format should be this format xxxx@xxx.xxx|
      | INVALIDREGISTERUSER                       | valid@acme.com     | The password field cannot be left blank!|







