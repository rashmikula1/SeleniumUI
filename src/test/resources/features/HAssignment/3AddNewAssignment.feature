
@tag
Feature: Add new assignment 
  

Background: 
Given Admin click +Add new assignment button after reaching to manage assignment page

  #1
  Scenario Outline: Validate if admin able to add new assignment with valid data 
    Given Admin is in  assignment details popup window
     When Admin enters all mandatory field values with valid data and clicks save button
    Then Admin should see new assignment details is added in the data table
    Examples:
    |Assignment Name|
    |Java|

#2
  Scenario Outline: Validate if admin able to add new assignment with invalid data in mandatory fields
  Given Admin is in  assignment details popup window
  When Admin enters all mandatory field values with invalid data and clicks save button 
  Then Error message should appear in alert in assignment
  Examples:
  |Assignment Name|
  |rttyyu|
  
  #3
  Scenario Outline: Validate admin able to add new assignment with valid data  in all fields
  Given Admin is in  assignment details popup window
  When Admin enters values in all fields with valid data and clicks save button Program name , batch number,Assignment Name, Assignment Description, grade by, Assignment due date,  Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5
  Then Admin should see new assignment details is added in the data table
  |Assignment Name|
    |Junit|
  
  #4
  Scenario Outline: Validate admin able to add new assignment with invalid data  in optional fields
  Given Admin is in  assignment details popup window
  When Admin enters with invalid data in optional fields and clicks save button
  Then Error message should appear in alert in assignment
  Examples:
  |Assignment Description|Grade By| File Location1|File Location2| File Location3|
  |unkown|ui|testlocation1|testlocation2|testlocation3|
 #5
  Scenario Outline: Validate admin able to add new assignment missing program name
  Given Admin is in  assignment details popup window
  When Admin enters  data missing value in program name and clicks save button
  Then Program Name is missing error  appear in assignment
  Examples:
   |Assignment Name|
    |API|
 #6
  Scenario Outline: Validate admin able to add new assignment missing batch number
  Given Admin is in  assignment details popup window
  When Admin enters data missing value in Batch number and clicks save button 
  Then Batch number is missing error appears in assignment
  Examples:
  |Assignment Name|
    |SOAPAPI|
  
  #7
  Scenario Outline: Validate admin able to add new assignment missing due date
  Given Admin is in  assignment details popup window
  When Admin enters data missing value in Assignment due date and clicks save button  Program name, batch number,Assignment Name, grade by
  Then Assignment due date is missing error appears
  |Assignment Name|
    |Science|
  
 #8
  Scenario Outline: Validate admin able to add new assignment missing grade by
  Given Admin is in  assignment details popup window
  When Admin enters data missing value in grade by  and clicks save button
  Then Grade by is missing appears in assignment
  Examples:
  |Assignment Name|
  |SOAPAPI|
  
  #9
  Scenario Outline: Validate  admin able to add new assignment passing past date 
  Given Admin is in  assignment details popup window
  When Admin enters passed date in the due date field and clicks save button
  Then Assignment cannot be created for the passed date
  Examples:
  |Assignment Name|
    |SOAPAPI|
  
 #10
  Scenario: Validate date picker
  Given Admin is in  assignment details popup window
  When Admin clicks date from date picker in assignment
  Then selected date should be their in class date text box in assignment
  
#11
  Scenario: validate date picker should be correct format
  Given Admin is in  assignment details popup window
  When Admin clicks date from date picker in assignment
  Then selected date should be in  mm/dd/yyyy format in assignment
  
  #12
  Scenario: Validate right arrow in data picker to navigate to next month
  Given Admin is in  assignment details popup window
  When Admin clicks right arrow in the date picker near month in assignment
  Then Next month calender should visible in assignment
  
  #13
  Scenario: Validate left arrow in data picker to navigate to previous month
  Given Admin is in  assignment details popup window
  When Admin clicks left arrow in the date picker near month in assignment
  Then previous month calender should visible in assignment
  
  #14
  Scenario: Validate current date is highlighted in the date picker
  Given Admin is in  assignment details popup window
  When Admin clicks date picker button in assignment
  Then Admin should see current date is highled in the date picker in assignment
  
#15
  Scenario: Validate selected date is highlighted in the date picker
  Given Admin is in  assignment details popup window
  When Admin clicks date picker button and selects future date in assignment
  Then Admin should see selected date is highled in the date picker in assignment
  
  #16
  Scenario: Validate cancel button function in assignment details popup window
  Given Admin is in  assignment details popup window
  When Admin clicks Cancel button without entering values in the fields in assignment
  Then Admin should land on manage assignment page
  
  #17
  Scenario: Validate cancel button function in assignment details popup window with values in field
  Given Admin is in  assignment details popup window
  When Admin clicks Cancel button entering values in the fields in assignment
  Then Admin should land on manage assignment Page and validate new assignment is not created in the data table
  
  
  
 
