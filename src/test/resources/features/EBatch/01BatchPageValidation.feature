Feature: Batch Page Validation
Background:
Given Logged on the LMS portal
#1
Scenario: Validate header in the Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin should see the "Manage Batch" in the URL in batch
#2
Scenario: Validate header in the Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin should see the "Manage Batch" in the header in batch
#3
Scenario: Validate pagination in the Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin should see the pagination controls "Showing x to y of z entries" and "In total there are z programs" under the data table in batch
#4
Scenario Outline: Validate data table headers in the Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin Should see the data table with headers "Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete" in batch
Examples:
|coulumn headers|
|Batch Name| 
|Batch Description| 
|Batch Status| 
|No.of classes|
|Edit|
|Delete|
#5
Scenario: Validate Delete button in Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin should be able to see the "Delete" icon button that is disabled in batch
#6
Scenario: Validate "+ A New batch" in Batch Page
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Admin should be able to see the "+ A New batch" button in batch
#7
Scenario: Validate data rows
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Each row in the data table should have a checkbox in batch
#8
Scenario: Validate data rows
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Each row in the data table should have a edit icon that is enabled in batch
#9
Scenario: Validate data rows
Given Admin is on dashboard page after Login in batch
When Admin clicks "Batch" from navigation bar in batch
Then Each row in the data table should have a delete icon that is enabled in batch
#10
Scenario: Validate pop up for adding batch
Given Admin is on dashboard page after Login in batch
When Admin clicks "+ A New Batch" button in batch
Then A new pop up with Batch details appears in batch