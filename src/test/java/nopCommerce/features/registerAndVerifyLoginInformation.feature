Feature: Register And Login Then Verify information

  @register_login_new_customer
  Scenario Outline: Register to System
    Given Click to "Register" menu link
    When Click to "<Gender>" radio button
    And Input to "FirstName" textbox with value "<First Name>"
    And Input to "LastName" textbox with value "<Last Name>"
    And Select "DateOfBirthDay" dropdown menu with value "<Day Dob>"
    And Select "DateOfBirthMonth" dropdown menu with value "<Month Dob>"
    And Select "DateOfBirthYear" dropdown menu with value "<Year Dob>"
    And Input to "Email" textbox with value "<Email>"
    And Input to "Company" textbox with value "<Company>"
    And Input to "Password" textbox with value "<Password>"
    And Input to "ConfirmPassword" textbox with value "<Password>"
    And Click to "Register" button
    Then Register Successful message displayed
    When Click to "Log in" menu link
    And Input to "Email" textbox with value "<Email>"
    And Input to "Password" textbox with value "<Password>"
    And Click to "Log in" button
    Then Verify "My account" link displayed
    Given Click to "My account" menu link
    Then Display the valid value at radio button with "<Gender>"
    And Display the valid value at "FirstName" textbox with "<First Name>"
    And Display the valid value at "LastName" textbox with "<Last Name>"
    And Display the valid value at "DateOfBirthDay" menu with "<Day Dob>"
    And Display the valid value at "DateOfBirthMonth" menu with "<Month Dob>"
    And Display the valid value at "DateOfBirthYear" menu with "<Year Dob>"
    And Display the valid value at "Email" textbox with "<Email>"
    And Display the valid value at "Company" textbox with "<Company>"

    Examples:
      | Gender | First Name | Last Name | Day Dob | Month Dob | Year Dob | Email | Company       | Password |
      | Male   | Johny      | Lavabo    | 3       | January   | 1997     | Email | Automation FC | 123456   |



