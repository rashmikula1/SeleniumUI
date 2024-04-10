
Feature: Delete Multiple User

Scenario:
Given Admin is on dashboard page after Login in user
When Admin clicks "User" from navigation bar
Then Admit directed to Manage User Page


Scenario: Validate the delete icon below the header 
Given None of the checkboxes in data table are selected
When No action performed
Then The delete icon under the "Manage User" header should be disabled


Scenario: Check for single row delete
Given One of the checkbox or row is selected
When Click delete icon below "Manage User" header
Then The respective row in the data table is deleted


Scenario: Check for multi row delete
Given Two or more checkboxes or row is selected
When Click delete icon below "Manage User" header
Then The respective row in the data table is deleted