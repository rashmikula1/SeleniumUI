Feature: Pagination in manage attendance

Background: Logged on the LMS portal as Admin
Given Admin is on dashboard page after Login


Scenario: Verify sheet one is displayed on default in data table
When Admin clicks "attendance" button on the navigation bar in attendance
Then Data table should display 1 page when entries are available in attendance

Scenario: Verify right arrow is enable when sheet one is displayed in data table
When Admin clicks "attendance" button on the navigation bar in attendance
Then Right arrow should be enabled in page one when entries available are more than 5 in attendance data table

Scenario: Verify left arrow is disable when sheet one is displayed in data table
When Admin clicks "attendance" button on the navigation bar in attendance
Then Left arrow should be disabled in page one when entries available are more than 5 in attendance data table

Scenario: Verify right arrow is enable when sheet two is displayed in data table when entries are more than 10
When Admin clicks "attendance" button on the navigation bar in attendance
Then Right arrow should be enabled in page two when entries available are more than 10 in attendance data table

Scenario: Verify left arrow is enable when sheet two is displayed in data table
When Admin clicks "attendance" button on the navigation bar in attendance
Then Left arrow should be enabled in page two when entries available are less than 10 in attendance data table 

Scenario: Verify right arrow is disable when sheet two is displayed in data table when entries are less than 10
When Admin clicks "attendance" button on the navigation bar in attendance
Then Data table should display page 1 when entries available

Scenario: Verify pagination controls enabled
When Admin clicks "attendance" button on the navigation bar in attendance
Then when entries are more than 5 in data table pagination controls are enabled in attendance

Scenario: Verify pagination controls disabled
When Admin clicks "attendance" button on the navigation bar in attendance
Then when entries are less than 5 in data table pagination controls disabled in attendance

