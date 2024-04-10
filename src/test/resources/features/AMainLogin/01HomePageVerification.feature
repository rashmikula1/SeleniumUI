Feature: Home Page Verification

  Background: 
    Given Admin user is in home page

  #1
  Scenario: Verify admin is able to land on home page
    When Admin enter the correct LMS portal URL
    Then Admin should land on the home page

  #2
  Scenario: Verify admin is able to land on home page with invalid URL
    When Admin enter the incorrect LMS portal URL
    Then Admin should land on the home page

  #3
  Scenario: Verify for broken link
    When Admin enter the incorrect LMS portal URL
    Then HTTP response >=404 page not found error

  #4
  Scenario: Verify the text spelling in the page
    When Admin enter the correct LMS portal URL
    Then Admin should see correct spellings in all fields of homepage

  #5
  Scenario: Verify the logo of the LMS
    When Admin enter the correct LMS portal URL
    Then Admin should see correct logo of the LMS

  #6
  Scenario: Verify the logo properly aligned
    When Admin enter the correct LMS portal URL
    Then Admin should see logo is properly aligned

  #7
  Scenario: Verify login button is present
    When Admin enter the correct LMS portal URL
    Then Admin should see login button

  #8
  Scenario: Verify login button is clickable
    When Admin enter the correct LMS portal URL
    Then Admin should able to click the Login button

  #9
  Scenario: Verify the login page
    When Admin clicks Login button
    Then Admin should land on the login page

  #10
  Scenario: Verify for broken link
    When Admin clicks Login button
    Then HTTP response >= 400 the "<url>" is broken

  #11
  Scenario: Verify admin has not able to land on home page with invalid URL
    When Admin enter the incorrect LMS portal URL
    Then HTTP response >= 400 the "<invalidLMSURL>" is broken