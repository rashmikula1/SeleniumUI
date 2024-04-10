
Feature: Pagination
Background :
Given Admin is on Manage Program Page after logged in
#1
Scenario: Verify Next page link
Given Admin is on Manage Program page in program
When Admin clicks Next page link on the program table in program
Then Admin should see the Pagination has Next page in program
#2
Scenario: Verify Last page link
Given Admin is on Manage Program page in program
When Admin clicks Last page link in program
Then Admin should see the last page record on the table with Next page link are disabled in program
#3
Scenario: Verify First page link
Given Admin is on Manage Program page in program
When Admin clicks First page link in program
Then Admin should see the current page record on the table with pagination has previous page link in program
#4
Scenario: Verify start page link
Given Admin is on Manage Program page in program
When Admin clicks Start page link in program
Then Admin should see the very first page record on the table with Previous page link are disabledFeature: Pagination in program
