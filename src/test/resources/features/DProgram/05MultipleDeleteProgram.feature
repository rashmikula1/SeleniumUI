Feature: Multiple Delete Program
Rule:Admin clicks program on the navigation bar
Background:
Given Admin is on dashboard page after Login and clicks Program on the navigation bar

#1
Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin is on Manage Program page in program
When Admin clicks any checkbox in the data table in program
Then Admin should see common delete option enabled under header Manage Program 

#Rule:Admin clicks checkbox and then clicks delete button
#Background:
Given Admin clicks delete button under header after selecting the check box in the data table

#2
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert in program
When Admin clicks <YES> button on the alert in program
Then Admin should land on Manage Program page and can see the selected program "program" is deleted from the data table in program

#3
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert in program
When Admin clicks <NO> button on the alert in program
Then Admin should land on Manage Program page and can see the selected program "program" is not deleted from the data table in program

#Rule:Admin clicks multiple checkbox and then clicks delete button
#Background:
Given Admin clicks delete button under header after selecting multiple checkboxes in the data table

#4
Scenario: Validate multiple program deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert in program
When Admin clicks <YES> button on the alert in program
Then Admin should land on Manage Program page and can see the selected programs are deleted "<program>" from the data table in program


#5
Scenario:Validate multiple program deletion by selecting multiple check boxes
Given  Admin is on Confirm Deletion alert in program
When Admin clicks <NO> button on the alert in program
Then Admin should land on Manage Program page and can see the selected programs are not deleted "<program>" from the data table in program
