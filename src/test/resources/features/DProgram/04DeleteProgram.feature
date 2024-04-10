Feature: Delete Program
Rule: Admin clicks program on navigation bar
Background:
Given Admin is on dashboard page after Login and clicks Program on the navigation bar

#1
Scenario: Delete Feature
Given Admin is on Manage Program Page in program
When Admin clicks <Delete> button on the data table for any row in program
Then Admin should see a alert open with heading "Confirm" along with "<YES>" and "<NO>" button for deletion
#2
Scenario: Validate details for Confirm Deletion form
Given Admin is on Manage Program Page in program
When Admin clicks <Delete> button on the data table for any row in program
Then Admin should see a message "Are you sure you want to delete <Program name>?" in program

#Rule:Admin is on manage program page
#Background:
Given Admin is on Manage Program Page after clicks Program on the navigation bar


#3
Scenario: Click Yes on deletion window
Given Admin is on Confirm Deletion alert in program
When Admin clicks <YES> button on the alert in program
Then Admin gets a message "Successful Program Deleted" alert and able to see that "program" deleted in the data table in program

#4
Scenario: Click No on deletion window
Given Admin is on Confirm Deletion alert in program
When Admin clicks <NO> button on the alert in program
Then Admin can see the deletion alert disappears without deleting in program

#5
Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
Given Admin is on Confirm Deletion alert in program
When Admin clicks Cancel or Close Icon on Deletion alert in program
Then Admin can see the deletion alert disappears without any changes in "program" in delete alert
