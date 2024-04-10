Feature: Edit new user

Scenario: Validate row level edit icon
Given The edit icon on row level in data table is enabled
When Admin clicks the edit icon
Then A new pop up with User details appears



Scenario: Check if the fields are updated
Given Admin clicks the edit icon
When Update the fields with valid values and click submit
Then The updated user details should appear on the data table


Scenario: Check if the update throws error with invalid values
Given Admin clicks the edit icon
When Update the fields with invalid values and click submit
Then Error message should appear


Scenario: Check if you get error message when mandatory fields are erased
Given Admin clicks the edit icon
When Erase data from mandatory field
Then Error message should appear


Scenario: Check if description field is optional in update
Given Admin clicks the edit icon
When Erase data from mandatory field
Then The updated user details should appear on the data table