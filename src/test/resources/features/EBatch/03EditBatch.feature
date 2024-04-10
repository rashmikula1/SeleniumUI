Feature: Edit Batch
Background:
Given Logged on the LMS portal Admin is on dashboard
#1
Scenario: Validate row level edit icon
Given The edit icon on row level in data table is enabled in batch
When Admin clicks the edit icon in batch
Then A new pop up with Batch details appears in batch
#2
Scenario Outline: Check if the fields are updated
Given Admin clicks the edit button in batch
When Update the fields with valid values "<Sheetname>" and <RowNumber> and click save in batch
Then The updated batch details should "batch name","batch desc" appear on the data table in batch
Examples:
|Sheetname|RowNumber|
|batch|6|

#3
Scenario Outline:	Check if the update throws error with invalid valued
Given Admin clicks the edit button in batch
When Update the fields with invalid values "<Sheetname>" and <RowNumber> and click save in batch
Then Error message should "cannot update" appear in batch
Examples:
|Sheetname|RowNumber|
|batch|7|

#4
Scenario Outline: Check if you get error message when mandatory fields are erased
Given Admin clicks the edit button in batch
When Erase data from mandatory field "<Sheetname>" and <RowNumber> in batch
Then Error message should "cannot update" appear in batch
Examples:
|Sheetname|RowNumber|
|batch|8|

#5
Scenario Outline: Check if description field is optional in update
Given Admin clicks the edit button in batch
When Erase data from description field "<Sheetname>" and <RowNumber> and enters valid details in batch
Then The updated batch details should "batch name","batch desc" appear on the data table in batch
Examples:
|Sheetname|RowNumber|
|batch|9|
