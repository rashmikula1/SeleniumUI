Feature: Add new Batch
Background:
Given Logged on the LMS portal Admin is on dashboard
#1
Scenario: Check if the fields exist in pop
Given A new pop up with Batch details appears in batch
Then The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down,Status as radio button,Number of classes as text box in batch
#2
Scenario Outline: Check if description is optional field
Given A new pop up with Batch details appears in batch
When Fill in all the fields "<Sheetname>" and <RowNumber> except description with valid values in batch
Then The newly added batch "batchname" should be present in the data table in Manage Batch page in batch
Examples:
|Sheetname|RowNumber|
|batch|1|

#3
Scenario Outline: Check if the program details are added in data table
Given A new pop up with Batch details appears in batch
When Fill in all the fields with valid values "<Sheetname>" and <RowNumber> and click save in batch
Then The newly added batch "batch name" should be present in the data table in Manage Batch page in batch
Examples:
|Sheetname|RowNumber|
|batch|2|
#4
Scenario Outline: Check for error messages for invalid fields
Given A new pop up with Batch details appears in batch
When any of the fields have invalid values "<Sheetname>" and <RowNumber> as valid  in batch
Then Error message should "cannot add batch" appear in batch
Examples:
|Sheetname|RowNumber|
|batch|3|

#5
Scenario Outline: Check for error messages for mandatory fields
Given A new pop up with Batch details appears in batch
When Any of the mandatory fields are blank and valid details "<Sheetname>"and <RowNumber> in batch
Then  Error message should "cannot add batch" appear in batch
Examples:
|Sheetname|RowNumber|
|batch|4|

