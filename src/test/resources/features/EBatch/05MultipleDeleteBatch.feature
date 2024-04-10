Feature: Delete multiple batches
Background:
Given Logged on the LMS portal Admin is on dashboard
#1
Scenario: Validate the delete icon below the header
Given None of the checkboxes in data table are selected in batch
Then The delete icon under the manage batch header should be disabled in batch
#2
Scenario: Check for single row delete
Given	 One of the checkbox row is selected in batch
When Click delete icon below Manage Batch header in batch
Then The respective row "batchname" in the data table is deleted in batch
#3
Scenario: Check for multi row delete
Given Two or more checkboxes row is selected in batch
When Click delete icon below Manage Batch header in batch
Then The respective rows "batchnameA","batchnameB" in the data table is deleted in batch