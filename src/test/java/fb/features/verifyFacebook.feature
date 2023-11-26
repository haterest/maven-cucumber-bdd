Feature: nopCommerce login page

  @displayed
  Scenario Outline: Verify login page
#    Given Open nopCommerce application
    Given Click to Login menu
    And Input to Username and Password
      | Username   | Password   |
      | <Username> | <Password> |
    Then Click To Login button
#    Then Close application

    Examples:
      | Username                 | Password |
      | automationfc01@gmail.com | 123456   |
#      | automationfc02@gmail.com | 123456   |
#      | automationfc03@gmail.com | 123456   |
