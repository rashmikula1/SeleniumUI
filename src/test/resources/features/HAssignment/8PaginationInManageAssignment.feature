Feature: Pagination in manage assignment

Rule:Logged on the LMS portal as Admin

Background:
Given Logged on the LMS portal as Admin
#1
Scenario: Verify sheet one is displayed on default in data table in assignment
Given Admin is on dashboard page after Login in assignment
When Admin clicks "Assignment" button on the navigation bar
Then Data table should display 1 page  when entries available in assignment
#2
Scenario: Verify  right arrow is enable when sheet one is displayed in data table
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then Right arrow should be enabled in page one  when entries are more than 5 available in assignment

#3
Scenario: Verify  left arrow is disable when sheet one is displayed in data table
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then Left arrow should be disabled in page one  when entries are more than 5 available in assignment

#4
Scenario: Verify  right arrow is enable when sheet two is displayed in data table when entries are more than 10
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then Right arrow should be enabled in page two when entries are more than 10 available in assignment

#5
Scenario: Verify  left arrow is enable when sheet two is displayed in data table
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then Left arrow should be enabled in page two  in assignment

#6
Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10

Given Admin is on dashboard page after Login 
When Admin clicks "Assignment" button on the navigation bar
Then Data table should display 1 page  when entries available in assignment

#7
Scenario: Verify pagination controls enabled
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then When entries are more than 5 in data table pagination controls enabled in assignment

#8
Scenario: Verify pagination controls disabled
Given Admin is on dashboard page after Login
When Admin clicks "Assignment" button on the navigation bar
Then When entries are less than 5 in data table pagination controls disabled in assignment

#Rule: Admin click +Add New assignment button 

#Background:
Given Admin click +Add new assignment button after reaching to manage assignment page

#9
Scenario: Verify next page is enabled
Given Admin is in add assignment details popup window
When Admin creates 6 new assignment
Then When total class entries above 5 next page is enabled in assignment
|Java|


#10
Scenario: verify next page is disabled
Given Admin is in add assignment details popup window
When Admin creates less than or equal to 5 new  assignment 
Then When total class entries  5 or below next page is disabled in assignment












