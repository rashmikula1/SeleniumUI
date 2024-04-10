
Feature: Delete multiple class validation

Rule: Admin logged into LMS portal and clicks assignment button 
Background
Given Admin logged into LMS portal and clicks assignment button on the navigation bar 

#1
Scenario: Verify delete multiple class  button is enabled
Given Admin is in manage assignment page
When Admin clicks single  row level check box in the data table in assignment
Then Admin should see delete icon below the header is enabled in assignment

#Rule: Admin clicks delete button under header after selecting the check box

#Background
Given Admin clicks delete button under header after selecting the check box in the data table

#2
Scenario: Verify accept alert in delete multiple class function by selecting single checkbox
Given Admin is in delete alert in assignment
When Admin clicks yes button in assignment
Then Redirected to assignment page and selected assignment details are deleted from the data table

#3
Scenario: Verify reject alert in delete multiple class function by selecting single checkbox
Given Admin is in delete alert in assignment
When Admin clicks no button in assignment
Then Redirected to assignment page and selected assignment details are not deleted from the data table

#4
Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
Given Admin is in delete alert in assignment
When Admin clicks yes button in assignment
Then Redirected to assignment page and selected assignment details are not deleted from the data table

#5
Scenario: Verify reject alert in delete multiple class function by selecting multiple checkbox
Given Admin is in delete alert in assignment
When Admin clicks no button in assignment
Then Redirected to assignment page and selected assignment details are not deleted from the data table

