Feature: Homepage
  This feature takes the user to www.homedepot.com home page
  Scenario: On the Home page
    Given user goes to the home page of the application
    And search "drill"
    Then User validates products are listed
    And Validate the selected ptoducts details