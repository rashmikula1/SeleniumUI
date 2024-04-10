Feature: Manage Program Validation
Rule: User is validating manage program page
Background:  
Given Logged on the LMS portal as Admin 
#1
Scenario: Validate landing in Program page
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see URL with "Manage Program" in program
#2
Scenario: Validate the heading
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see a heading with text "Manage Program" on the page in program
#3
Scenario: Validate the text and pagination icon below the data table
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon in program. 
#4
Scenario: Validate the footer
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see the footer as "In total there are z programs" in program.


#5
Scenario: Validating the default state of Delete button
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see a Delete button on the top left hand side as Disabled in program
#6
Scenario: Validate Add New Program 
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see a "+A New Program" button on the program page above the data table in program
#7
Scenario: Validate that number of records (rows of data in the table) displayed
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see the number of records (rows of data in the table) displayed on the page are 5 in program
#8
Scenario Outline: Verify data table on the Program page
Given Admin is on dashboard page after Login in program
When Admin clicks "<Program>" on the navigation bar in program
Then Admin should see data table on the Manage Program Page with column headers "<Program Name>","<Program Description>","<Program status>","<edit>","<delete>" in program
Examples:
|Program|
|Program Name| 
|Program Description| 
|Program Status| 
|Edit|
|Delete|
#9
Scenario: Verify Sort arrow icon on the data table
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete in program
#10
Scenario: Verify Check box on the data table
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see check box on the left side in all rows of the data table in program
#11
Scenario: Verify Edit and Delete buttons
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see the Edit and Delete buttons on each row of the data table in program
#12
Scenario: Verify Search bar on the Program page
Given Admin is on dashboard page after Login in program
When Admin clicks "Program" on the navigation bar in program
Then Admin should see Search bar with text as "Search..." in program

#Rule: Admin is able to navigate to program
#Background:
Given Admin is on dashboard page after Login and clicks Program on the navigation bar

#13
Scenario Outline: Search Program By Name
Given Admin is on Manage Program Page in program
When Admin enters "<Program name phrase>" into search box in program.
Then Admin should see the Programs displayed based on the Program Name in program
Examples:
|Program Name|
|jan_techwarrior|

#14
Scenario Outline: Search Program By Description
Given Admin is on Manage Program Page in program
When Admin enters "<Program description phrase>" into the search box in program.
Then Admin should see the Programs displayed based on the Program Description in program
Examples:
|Program Description|
|jan_TechWarrior_sdet_Desc|
#15
Scenario Outline: Search Program By Status
Given Admin is on Manage Program Page in program
When Admin enters "<Program status phrase>" in search box in program.
Then Admin should see the Programs displayed based on the Program Status in program
Examples:
|Program Status|
|Active|

#16
Scenario Outline: Validating the Search with unrelated keyword
Given Admin is on Manage Program Page in program
When Admin enters the keywords not present in the data table "elephant" on the Search box in program 
Then Admin should see zero entries on the data table in program
Examples:
|elephant|



																		