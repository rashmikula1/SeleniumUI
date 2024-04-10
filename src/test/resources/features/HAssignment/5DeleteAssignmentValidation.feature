
Feature: Delete Assignment validation

Rule:Admin logged into LMS portal and clicks assignment button
Background: 
Given Admin logged into LMS portal and clicks assignment button on the navigation bar 

#1
Scenario:Verify Delete Assignment alert

Given Admin is in manage assignment page
When Admin clicks delete button in data table row level in assignment
Then Admin should see dialog box in assignment

#2
Scenario:
Given Admin is in manage assignment page
When Admin clicks delete button in data table row level in assignment
Then Alert should have yes button to accept in assignment

#3
Scenario:
Given Admin is in manage assignment page
When Admin clicks delete button in data table row level in assignment
Then Alert should have No button to reject in assignment

#Rule: Admin clicks row level delete button 
#Background:
Given Admin clicks row level delete button after landing to manage assignment page

#4
Scenario: Validate accept in alert
Given Admin is in delete alertin assignment
When Admin clicks yes button in assignment
Then Redirected to assignment page and selected assignment details are deleted from the data table

#5
Scenario: Validate reject in alert
Given Admin is in delete alert in assignment
When Admin clicks no button in assignment
Then Redirected to assignment page and selected assignment details are not deleted from the data table