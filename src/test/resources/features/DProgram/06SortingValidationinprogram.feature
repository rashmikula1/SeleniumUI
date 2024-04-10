Feature: Sorting(Data Ordering) Validation
Background:
Given
Admin is on Manage Program Page after clicks Program on the navigation bar

#1
Scenario: Validates Sorting(data ordering) on the Program Data table
Given Admin is on Manage Program page in program
When Admin clicks the sort icon of program name column in program
Then The data get sorted on the table based on the program name column values in ascending order in program
#2
Scenario: Validates Sorting(data ordering) on the Program Data table
Given The data is in the ascending order on the table based on Program Name column in program
When Admin clicks the sort icon of program name column in program
Then The data get sorted on the table based on the program name column values in descending order in program

#3
Scenario: Validates Sorting(data ordering) on the Program Data table
Given Admin is on Manage Program page in program
When Admin clicks the sort icon of program Desc column in program
Then The data get sorted on the table based on the program description column values in ascending order in program

#4
Scenario: Validates Sorting(data ordering) on the Program Data table
Given The data is in the ascending order on the table based on Program Description column in program
When Admin clicks the sort icon of program Desc column in program
Then The data get sorted on the table based on the program description column values in descending order in program

#5
Scenario: Validates Sorting(data ordering) on the Program Data table
Given Admin is on Manage Program page in program
When Admin clicks the sort icon of program Status column in program
Then The data get sorted on the table based on the program status column values in ascending order in program


#6
Scenario: Validates Sorting(data ordering) on the Program Data table

Given The data is in the ascending order on the table based on Program Status column in program
When Admin clicks the sort icon of program Status column in program
Then The data get sorted on the table based on the program status column values in descending order in program


