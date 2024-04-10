Feature: Add New Program
Rule: Admin is able to navigate to program
Background:
Given Admin is on dashboard page after Login and clicks Program on the navigation bar

#1
Scenario: Validate Program Details Popup window
Given Admin is on Manage Program Page in program
When Admin clicks <A New Program>button in program
Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close Icon on the top right corner of the window in program

#2
Scenario: Validate input fields and their text boxes in Program details form 
Given Admin is on Manage Program Page in program
When Admin clicks <A New Program>button in program
Then Admin should see two input fields and their respective text boxes in the program details window in program
 
 #3
 Scenario: Validate radio button for Program Status 
 Given Admin is on Manage Program Page in program
 When Admin clicks <A New Program>button in program
 Then Admin should see two radio button for Program Status in program
 
##Rule:Admin is able to navigate to manage program page
#Background:
Given Admin is on Manage Program Page after clicks Program on the navigation bar

#4
Scenario: Empty form submission
Given Admin is on Program Details Popup window in program
When Admin clicks <Save>button without entering any data in program
Then Admin gets a Error message alert "fill the details" in program

#5
Scenario Outline: Enter only Program Name
Given Admin is on Program Details Popup window in program
When Admin enters only "program name" in text box and clicks Save button in program
Then Admin gets a message alert in program
Examples:
|Sheetname|RowNumber|
|program|1|
#6
Scenario Outline: Enter only Program Description
Given Admin is on Program Details Popup window in program
When Admin enters only "program description" in text box and clicks Save button in program
Then Admin gets a message alert in program
Examples:
|Sheetname|RowNumber|
|program|2|

#7
Scenario: Select Status only
Given Admin is on Program Details Popup window in program
When Admin selects only Status and clicks Save button in program
Then Admin gets a message alert in program

#8
Scenario Outline: Validate invalid values on the text column
Given Admin is on Program Details Popup window in program
When Admin enters only numbers or special char "<Sheetname>" and "RowNumber" in name and desc column in program
Then Admin gets a message alert in program
Examples:
|Sheetname|RowNumber|
|program|3|

#9 
Scenario: Validate Cancel/Close(X) icon on Program Details form
Given Admin is on Program Details Popup window in program
When Admin clicks Cancel or Close Icon on Program Details form in program
Then Program Details popup window should be closed without saving in program

#10
Scenario Outline: Validate Save button on Program Details form
Given Admin is on Program Details Popup window in program
When Enter all the required fields with valid values "<Sheetname>" and "<RowNumber>" and click Save button in program
Then Admin gets a message "Successful Program Created" alert and able to see the "new program" added in the data table in program
Examples:
|Sheetname|RowNumber|
|program|4|
#11
Scenario: Validate Cancel button on Program Details form
Given Admin is on Program Details Popup window in program
When Admin clicks <Cancel>button in program
Then Admin can see the Program details popup disappears without creating any "program" in program











 