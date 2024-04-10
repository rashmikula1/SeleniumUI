@tag1
Feature: Manage ClassPage Verification

@Test01
Scenario:Verify LMS url
Given Admin  on the Browser
When Admin  enter the LMS url
Then Admin  is able to see LMS LoginPage

@Test02
Scenario Outline:Verify LMS LoginPage
Given Admin on LoginPage header
When Admin  enter the "<UserName>" and "<Password>" 
And Click the LoginButton
Then Admin  is able to see LMS Dashboard Page
  Examples:
    | Username   | Password |
    | testuser_1 | Test@01 |
    | testuser_2 | Test@02 |

@Test03
Scenario:Verify landing in class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see the "Manage Class"Page
@Test04
Scenario:Capture the response time to navigate to manage class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Get the response time for navigation from dashboard page to manage class page
@Test05
Scenario:Verify Manage Class Page Header
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see header with "Manage Class"
@Test06
Scenario:Validate text in manage class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see correct spelling for the all the fields
@Test07
Scenario:Verify delete icon below the header
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see disabled delete icon below the "Manage Class"
@Test08
Scenario:Verify search bar on the class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see search bar on the class page
@Test09
Scenario:Verify add new class button  on class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see +Add New Class button on the class page
@Test10
Scenario:Verify data table on the class page
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see data table on the Manage Class Page With following column headers.
 |Check box symbol|
 |Batch Id| 
 |Class No|
 |Class Date|
 |Class Topic|
 |Staff Id|
 |Description|
 |Comments|
 |Notes| 
  |Recording|
  |Edit|
 |Delete|
@Test11
Scenario:Verify Edit icon in the data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Edit Icon in each row of data table only  when entries are available

@Test13
Scenario:Verify delete icon in the data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Delete Icon in each row of data table only  when entries are available

@Test15
Scenario:Verify sort icon in the data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see sort icon near the column headers except for Edit and Delete
@Test16
Scenario:Verify check box in the data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see check box in the all rows  of data table 
@Test17
Scenario:Validate the number entries displaying
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Above the footer Admin should see the text as "Showing x to y of z entries" in the table 

 
@Test18
Scenario:Verify Pagination control below the data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see the pagination controls under the data table
@Test19
Scenario:Validate footer  text
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Admin should see the text with total number classes in the data table

@Test20
Scenario:Validate search box function
Given Admin is on Manage Class Page
When Admin enters batch id into search box 
Then Displays entries with that batch Id
When Admin enters batch id which is not existing the table into search box
Then Displays empty details in the data table
When Admin enters class no into search box 
Then Displays entries with that class no
When Admin enters class no which is not existing the table into search box  
Then Displays empty details in the data table
When Admin enters class topic into search box 
Then Displays entries with that  class topic
When Admin enters class topic which is not existing the table into search box 
Then Displays empty details in the data table
When Admin enters staff id into search box  
Then Displays entries with that  staff id
When Admin enters staff id which is not existing the table into search box 
Then Displays empty details in the data table
When Admin enters class date into search box  
Then Displays entries with that  class date
When Admin enters invalid class date into search box  
Then Displays empty details in the data table