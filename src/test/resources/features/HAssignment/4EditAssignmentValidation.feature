
Feature: Edit assignment Validation
Rule: Admin logged into LMS portal and clicks assignment button
Background: 
Given Admin logged into LMS portal and clicks assignment button on the navigation bar 
#1
Scenario: Verify Edit assignment popup window
   Given Admin is in manage assignment page
   When Admin clicks Edit button in data table  in assignment
   Then Edit popup window appears with heading Assignment Details
   
   #2
   Scenario: Verify values in popup window
   Given Admin is in manage assignment page
   When Admin clicks Edit button from one of the row in data table in assignment
   Then Edit popup window appears with same row values in the all fields in assignment
   
  # Rule:Admin clicks Edit button in manage assignment
  # Background: 
   Given Admin clicks Edit button in manage assignment after reaching manage assignment page
   
   #3
   Scenario: Validate if admin able to update assignment with valid data in mandatory fields
   Given Admin is in Edit assignment detail popup window
   When Admin enters all mandatory field values with valid data and clicks save button 
   Then Admin should see updated assignment details is added in the data table
   
   #4
   Scenario: Validate if admin able to update assignment with invalid data in mandatory fields
   Given Admin is in Edit assignment detail popup window
   When Admin enters all mandatory field values with invalid data and clicks save button
   Then Error message should appear in alert in assignment
   
   #5
   Scenario: Validate admin able to update assignment with valid data  in all fields
   Given Admin is in Edit assignment detail popup window
   When Admin enters values in all fields with valid data and clicks save button 
   Then Admin should see updated assignment details is added in the data table
   
   #6
   Scenario: Validate admin able to update assignment with invalid data  in optional fields
   Given Admin is in Edit assignment detail popup window
   When Admin enters with invalid data in optional fields and clicks save button
   Then Error message should appear in alert in assignment 
   
   #7
   Scenario: Validate admin able to update assignment missing program name
   Given Admin is in Edit assignment detail popup window
   When Admin enters  data missing value in program name and clicks save button 
   Then Program Name is missing in assignment
   
   #8
   Scenario: Validate admin able to update assignment missing batch number
   Given Admin is in Edit assignment detail popup window
   When Admin enters data missing value in Batch number and clicks save button 
   Then Batch number is missing in assignment
   
   #9
   Scenario: Validate admin able to update assignment missing assignment name
   Given Admin is in Edit assignment detail popup window
   When Admin enters data missing value in Assignment name and clicks save button 
   Then Assignment name is missing
   
   #10
   Scenario: Validate admin able to update assignment missing due date
   Given Admin is in Edit assignment detail popup window
   When Admin enters data missing value in Assignment due date and clicks save button 
   Then Assignment due date is missing
   
   #11
   Scenario: Validate if admin able to update assignment missing grade by
   Given Admin is in Edit assignment detail popup window
   When Admin enters data missing value in grade by  and clicks save button 
   Then Grade by is missing in assignment
   
   #12
   Scenario: Validate  admin able to update assignment passing past date 
   Given Admin is in Edit assignment detail popup window
   When Admin enters passed date in the due date field and clicks save button
   Then Assignment cannot be updated for the passed date
   
   #13
   Scenario: Validate cancel button function in assignment details popup window
   Given Admin is in Edit assignment detail popup window
   When Admin clicks Cancel button without entering values in the fields in assignment
   Then Admin should land on manage assignment page
   
   #14
   Scenario: Validate cancel button function in assignment details popup window with values in field
   Given Admin is in Edit assignment detail popup window
   When Admin clicks Cancel button entering values in the fields in assignment
   Then Admin should land on manage assignment Page and validate new assignment is not created in the data table










   
