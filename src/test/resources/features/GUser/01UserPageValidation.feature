Feature: User page validation

Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the "Manage User" in the URL


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the "Manage User" in the header


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the pagination controls under the data table


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin Should see the data table with headers


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "Delete" icon button that is disabled


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "+ A New User" button


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "+ Assign staff" button


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the search text box


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Each row in the data table should have a checkbox


Scenario: 
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Each row in the data table should have a edit icon that is enabled

 
Scenario: 
Given Admin is on dashboard page after Login 
When Admin clicks "User" from navigation bar
Then Each row in the data table should have a delete icon that is enabled


Scenario: 
Given Admin is on dashboard page after Login and Admin clicks "User" from navigation bar
When Admin clicks "+ A New User" button
Then A new pop up with User details appears