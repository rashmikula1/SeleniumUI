@tag7
Feature:Verify sort function in manage class page

 @Test73
Scenario:Verify sort function in data table for descending order
Given Admin is in Manage class page
When Admin click on Batch id column header to sort 
Then Admin should see data table sorted in descending order

@Test74
Scenario:Verify sort function in data table for ascending order
Given Admin is in Manage class page
When Admin double click on Batch id column header to sort 
Then Admin should see data table sorted in ascending  order