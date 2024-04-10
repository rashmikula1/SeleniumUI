Feature: Verify Assignment details popup window

  Background: Admin logged into LMS portal and clicks assignment button on the navigation bar

  #1
  Scenario: Verify Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see a popup  with  heading "Assignment details"

  #2
  Scenario: Verify input fields in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see input fields Text

  #3
  Scenario: Verify text box present in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then  8 textbox should be  present in Assignment details popup window

  #4
  Scenario: Verify drop down in Batch Number  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Batch Number

  #5
  Scenario: Verify drop down in Program name  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Program name

  #6
  Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  calendar icon for assignment due date

  #7
  Scenario: Verify save button is present
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  save button in the Assignment detail popup window

  #8
  Scenario: Verify cancel button is present
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  cancel button in the Assignment detail popup window

  #9
  Scenario: Verify close button in  Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  close button on the Assignment details popup window
