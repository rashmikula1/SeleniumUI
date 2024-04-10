@tag8
Feature:Pagination in manage class

 @Test75
Scenario:Verify sheet one is displayed on default in data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Data table should display 1 page  when entries available
@Test76
Scenario:Verify  right arrow is enable when sheet one is displayed in data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Right arrow should be enabled in page one  when entries are more than 5 available
@Test77
Scenario:Verify  left arrow is disable when sheet one is displayed in data table
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Left arrow should be disabled in page one  when entries are more than 5 available
@Test78
Scenario:Verify  right arrow is enable when sheet two is displayed in data table when entries are more than 10
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Right arrow should be enabled in page two when entries are more than 10 available
@Test79
Scenario:Verify  left arrow is enable when sheet two is displayed in data table 
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Left arrow should be enabled in page two  

@Test80
Scenario:Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then Data table should display  page 1 on entries available
@Test81
Scenario:Verify pagination controls enabled
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then entering more than 5 in data table pagination controls enabled
@Test82
Scenario:Verify pagination controls disabled
Given Admin is on dashboard page after Login
When Admin clicks "Class" button on the navigation bar
Then entering less than 5 in data table pagination controls disabled
@Test83
Scenario:Verify next page is enabled
Given Admin is in add class details popup window
When Admin creates 6 new class 
Then entering total class entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)
@Test84
Scenario:verify next page is disabled
Given Admin is in add class details popup window
When Admin creates less than or equal to 5 new class 
Then entering total class entries  5 or below next page is disabled
 