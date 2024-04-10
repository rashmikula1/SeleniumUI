
Feature: Manage assignment page Verification

Rule: Logged in to the LMS

Background:

Given Logged on the LMS portal as Admin
 #1
  Scenario Outline: Verify landing in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see URL with "Manage assignment"
    Examples:
    |Assignment|
   
  #2
  Scenario: Capture the response time to navigate to manage assignment page
   Given Admin is on dashboard page after Login	
   When Admin clicks "assignment" button on the navigation bar	
   Then Get the response time for navigation from dashboard page to manage assignment page
   
  #3
   Scenario: Verify manage assignment page Header
   Given Admin is on dashboard page after Login
   When Admin clicks "assignment" button on the navigation bar
   Then Admin should see header with "Manage assignment"
   
  #4
   Scenario: Validate text in manage assignment page
   Given Admin is on dashboard page after Login
   When Admin clicks "assignment" button on the navigation bar and get all text from the portal page
   Then Admin should see correct spelling for the all the fields
   
   #5
    Scenario: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see disabled delete icon below the "Manage assignment"
    #6
    Scenario: Verify search bar on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see search bar on the manage assignment page
    
    #7
    Scenario: Verify add new assignment button  on manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see +Add New assignment button on the manage assignment page
    
   #8
    Scenario: Verify data table on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see data table on the manage assignment page With following column headers.
    |Student|
    |Assignment|
    |User|
    |Batch|
    |Class|
    |Attendance|
   #9
    Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available
    
   #10
    Scenario: Verify Edit icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Edit Icon will not be present in data table
    
    #11
    Scenario: Verify delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available
    
    #12
    Scenario: Verify delete icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Delete Icon will not be present in data table
    
    #13
    Scenario: Verify sort icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete
    
    #14
    Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see check box in the all rows  of data table when entries available
    
    #15
    Scenario: Validate the number entries displaying
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Above the footer Admin should see the text as Showing x to y of z entries below the table. 
    
    
    #16
    Scenario: Verify Pagination control below the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see the pagination controls under the data table
    
   #17
    Scenario: Validate footer  text
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see the text with total number assignments in the data table. 
 
#Rule: Admin logged in and clicks assignment

#Background:
Given Admin logged into LMS portal and clicks assignment button on the navigation bar 

#18
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment name into search box  
Then Displays entries with that assignment name
Examples:
|Math|

#19
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment  name is not existing the table into search box  
Then Displays empty details in the data table
Examples:
|random|

#20
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment description into search box  
Then Displays entries with that assignment description
Examples:
|Java|



#21
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment description which is not existing the table into search box  
Then Displays empty details in the data table
Examples:
|test|

#22
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment due date into search box  
Then Displays entries with that assignment due date
Examples:
|9 Oct|

#23
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters assignment due date which is not existing the table into search box  
Then Displays empty details in the data table
|12 dec|

#24
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters grade value  into search box  
Then Displays entries with that assignment  grade
Examples:
|A|

#25
Scenario Outline: Validate search box function
Given Admin is on manage assignment page
When Admin enters grade value which is not existing the table into search box  
Then Displays empty details in the data table
Examples:
|testname|









  