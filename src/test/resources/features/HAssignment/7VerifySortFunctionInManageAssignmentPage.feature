
Feature: Verify sort function in manage assignment page



Background
Given Admin is manage assignment page after logged in

#1
Scenario: Verify sort function in data table for descending order

Given Admin is in manage assignment page
When Admin click on assignment name column header to sort 
Then Admin should see data table sorted in descending order
#2
Scenario: 

Given: Admin is in manage assignment page
When Admin double click on assignment name column header to sort 
Then Admin should see data table sorted in ascending  order


  
