
Feature: Dashboard Page Validation

Background: Logged on the LMS portal as Admin 
Given Admin user is in login page
When Admin user enter valid "username" with "password"  and clicks login button 
  	|username|password|
  	| testuser_1 | Test@153 |

#1
Scenario: Verify after login  admin lands on manage program as dashboard page
Then Admin should see manage program as header 

#2
Scenario: Verify the response time
Then Maximum navigation time in milliseconds, defaults to 30 seconds

#3
Scenario: Verify broken link
Then HTTP response >=400.The link boken

#4
Scenario: Verify LMS title 
Then Admin should see LMS -Learning management system  as title 

#5
Scenario: Verify LMS title allignment in Dashboard page
Then LMS title should be on the top left corner of page

#6
Scenario: Validate navigation bar text
Then Admin should see correct spelling in navigation bar text

#7
Scenario: Validate LMS title has correct spelling and space
Then Admin should see correct spelling and space in LMS title

#8
Scenario: Validate alignment for navigation bar
Then Admin should see the navigation bar text on the top right side

#9
Scenario Outline: Validate navigation bar order 1st Student
Then Admin should see student in the 1st place "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Student   |1          |
#10
Scenario Outline: Validate navigation bar order 2nd Program 
Then Admin should see program in the 2nd place "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Program   |2          |
#11
Scenario Outline: Validate navigation bar order  3rd Batch
Then Admin should see batch in the 3rd place "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Batch     |3         |
#12
Scenario Outline: Validate navigation bar order 4th Class
Then Admin should see class in the 4th place "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Class     |4         |
#13
Scenario Outline: Validate navigation bar order 5th User
Then Admin should see student in the  5th user "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|User     |5        |
#14
Scenario Outline: Validate navigation bar order 6th Assignment
Then Admin should see student in the  6th attendance "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Assignment     |6         |
#15 
Scenario Outline: Validate navigation bar order 7th Attendance
Then Admin should see student in the  7th attendance "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Attendance     |7         |
#16
Scenario Outline: Validate navigation bar order 8th Logout 
Then Admin should see student in the 8th logout "<Menuname>" and <Position_no>
Examples: 
		|Menuname  |Position_no|
		|Logout     |8         |
#17

Scenario: Verify Logout button function

When Admin click Logout button on navigation bar
Then Admin should land on login in page

 
