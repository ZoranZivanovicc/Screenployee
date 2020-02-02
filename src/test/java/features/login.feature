@regression @user_login
Feature: Testing login functionality
  As a qa
  I want to check positive and negative cases regarding with login

  Background:
    Given The system shows "SCREENPLOYEELOGIN" page

 Scenario Outline: Can login with an user

    When I choose to "logged in" with a "<UserName>" and "<Email>"
    Then I "logged in" and the system shows "SCREENPLOYEEPAGE"


   Examples:
     | UserName              |
     | VALIDLOGINUSER        |


  Scenario Outline: Can't login with an user
    When I choose to "logged in" with a "<UserName>" and "<Email>"
    Then "<ErrorMessage>" displayed


    Examples:
      | UserName                                  | Email              |ErrorMessage                                   |
      | INVALIDLOGINUSER                            |  ray@acme.com      | Invalid username/email/password combination |







