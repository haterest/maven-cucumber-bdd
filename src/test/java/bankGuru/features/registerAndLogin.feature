Feature: Register - Login and new Customer

  @resgister_login
  Scenario: Register to system and Login
    Given Get Login Page url
    When Open Register page
    And Input to Email textbox
    And Click to Submit button
    Then Get UserID and Password information
    When Back to Login page
    And Input valid UserID and Password to textbox
    And Click to Login button
    Then Homepage displayed

