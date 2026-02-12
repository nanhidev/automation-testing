
Feature: LoginScreenForRecruiters_pos @feature_user_login

  Background: 
    Given the user is on the Login Screen

  @valid-login
  Scenario Outline: Login Screen for Recruiters
    When I enter "<email>" in the Email ID field
    And I enter "<password>" in the Password field
    And I click on the 'Show Password' option to verify the password visibility
    And I click the Login button
    Then the user should be redirected to the dashboard
    And the dashboard loads successfully without errors

    Examples:
      | email                   | password            |
      | recruiter@example.com   | SecurePassword123    |

@valid-email-empty-password
Scenario Outline: Login Screen for Recruiters
  When I enter a valid email ID <email>
  And I leave the Password field empty
  Then the Login button should be disabled
  When I enter a valid password <password>
  Then the Login button should be enabled

  Examples:
    | email              | password      |
    | krishna@gmail.com  | password123   |

  @toggle_password_visibility
  Scenario Outline: Login Screen for Recruiters
    Given the user enters a valid password in the Password field
    When the user clicks on the 'Show Password' option
    Then the password should be visible
    When the user clicks on the 'Hide Password' option
    Then the password should be hidden
    Then the user can still log in successfully after toggling

    Examples:
      | password            |
      | ValidPassword123!   |

  @valid-email-login
  Scenario Outline: Login Screen for Recruiters
    When I enter a valid email ID "<email_id>"
    And I enter the correct password
    And I click the Login button
    Then the user is redirected to the dashboard successfully
    And the user logs out and returns to the login screen

    Examples:
      | email_id             |
      | user@mail.example.com |
      | user@example.com      |

  @feature_user_login
  @valid-login
  Scenario Outline: Login Screen for Recruiters
    Given the user enters a valid email ID <email>
    And the user enters the correct password <password>
    When the user clicks the Login button
    Then the user should be redirected to the dashboard successfully
    And the user logs out and returns to the login screen
    Given the user enters the same email ID <email>
    And the user enters the password <incorrect_password>
    When the user clicks the Login button
    Then an error message "Incorrect email ID or password." is displayed

    Examples:
      | email              | password      | incorrect_password |
      | krishna@gmail.com  | Password123   | password123        |

@valid-login-gmail
Scenario Outline: Login Process with Valid Email IDs
  When the user enters "<email>"
  And the user enters "<password>"
  And the user clicks the Login button
  Then the user should be redirected to the dashboard successfully
  And the user logs out and returns to the login screen

  Examples:
    | email             | password              |
    | user@gmail.com    | correctPassword123    |
    | user@yahoo.com    | correctPassword123    |

  @valid-login-alphanumeric
  Scenario Outline: Login Screen for Recruiters
    Given the user enters a valid email ID <email>
    And the user enters a password with <password_type> characters <password>
    And the user clicks the Login button
    Then the user is redirected to the dashboard successfully

    Examples:
      | email                | password_type      | password         |
      | krishna@gmail.com    | alphanumeric       | Password123      |
      | krishna@gmail.com    | special            | !@#Password      |

  @logout-and-return
  Scenario Outline: Logout and Return to Login Screen
    Given the user logs out and returns to the Login Screen
    Given the user enters the same email ID <email>
    And the user enters a password with <password_type> characters <password>
    And the user clicks the Login button
    Then the user is redirected to the dashboard successfully

    Examples:
      | email                | password_type      | password         |
      | krishna@gmail.com    | special            | !@#Password      |

  @valid-email-login
  Scenario Outline: Login Screen for Recruiters
    When the user enters "<email_id>"
    And the user enters "<password>"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard successfully
    And the user logs out and returns to the login screen

    Examples:
      | email_id             | password          |
      | user123@example.com  | correct_password   |
      | user456@example.com  | correct_password   |

  @valid-login-hyphens
  Scenario Outline: Login with Valid Email IDs Containing Hyphens
    When I enter "<email_id>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email_id                   | password              |
      | user-name@example.com      | correctPassword123    |
      | user-name123@example.com   | correctPassword123    |

  @logout-and-return
  Scenario Outline: Log out and return to the login screen
    When I log out
    Then the user should return to the Login Screen
    When I enter "<email_id>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email_id                   | password              |
      | user-name@example.com      | correctPassword123    |
      | user-name123@example.com   | correctPassword123    |
