Feature: Delete Multiple Attendance Validation

Background: Admin logged into LMS portal and clicks attendance button on the navigation bar 

Scenario: Verify delete multiple class button is enabled
Given Admin is in manage attendance page
When Admin clicks single row level check box in the data table in attendance
Then Admin should see delete icon below the header is enabled in attendance

Scenario: Verify tick mark is visible after clicking on check box for single data
Given Admin is in manage attendance page
When Admin clicks single row level check box in the data table in attendance
Then Admin should see tick mark in check box in attendance

Scenario: Verify admin able to click multiple check box
Given Admin is in manage attendance page
When Admin clicks multiple row level check box in the data table in attendance
Then Admin should see tick mark in check box of the selected rows in attendance

Scenario: Verify accept alert in delete multiple attendance by selecting single checkbox
Given Admin is in delete alert popup after clicking delete under header after selecting single check box in data table
When Admin clicks yes button in delete attendance alert	
Then Success message is displayed and selected attendance detail are deleted from the data table

Scenario: Verify reject alert in delete multiple attendance by selecting single checkbox
Given Admin is in delete alert popup after clicking delete under header after selecting single check box in data table	
When Admin clicks no button in delete attendance alert
Then Redirected to manage attendance page and selected attendance row is not deleted from the data table

Scenario: Verify accept alert in delete multiple attendance by selecting multiple checkbox
Given Admin is in delete alert popup after clicking delete under header after selecting single check box in data table	
When Admin clicks yes button in delete attendance alert
Then Success message is displayed and selected attendance detail are deleted from the data table

Scenario: Verify reject alert in delete multiple attendance by selecting multiple checkbox
Given Admin is in delete alert popup after clicking delete under header after selecting single check box in data table	
When Admin clicks no button in delete attendance alert
Then Redirected to manage attendance page and selected attendance rows are not deleted from the data table
