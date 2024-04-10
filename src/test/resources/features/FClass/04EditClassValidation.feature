@tag4
Feature: Edit class Validation

@Test48
Scenario:Verify Edit class popup window
Given Admin is in Manage class page
When  Admin clicks Edit button in data table 
Then Edit popup window appears with heading Class Details
@Test49
Scenario:Verify values in popup window
Given Admin is in Manage class page
When Admin clicks Edit button from one of the row in data table 
Then Edit popup window appears with same row values in the all fields
@Test50
Scenario:Validate admin able to update class with valid data in mandatory fields
Given Admin is in  Edit class detail popup window
When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then Admin should see particular class details is updated in the data table
@Test51
Scenario:Validate admin able to  update class with invalid data in mandatory fields
Given Admin is in  Edit class detail popup window
When Admin enters all mandatory field values with invalid data and clicks save button
Then Error message should appear in alert
@Test52
Scenario:Validate admin able to  update class with valid data  in all fields
Given Admin is in  Edit class detail popup window
When Admin enters values in all fields with valid data and clicks save button
Then Admin should see particular class details is updated in the data table
@Test53
Scenario:Validate admin able to  update  class with invalid data  in all fields
Given Admin is in  Edit class detail popup window
When Admin enters with invalid data in optional fields and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then Error message should appear in alert
@Test54
Scenario:Validate admin able to update class missing Batch Id
Given Admin is in  Edit class detail popup window
When Admin enters  data missing value in Batch ID and clicks save button (No of Classes, Class Date, Staff Id)
Then Batch Id is missing
@Test55
Scenario:Validate admin able to update  class missing No of Class
Given Admin is in  Edit class detail popup window
When Admin enters data missing value in No of class and clicks save button (Batch ID ,  Class Date, Staff Id, )
Then No of classes is missing
@Test56
Scenario:Validate admin able to update class missing Class Date
Given Admin is in  Edit class detail popup window
When Admin enters data missing value in  class date and clicks save button (Batch ID , No of Classes, Staff Id, )
Then class date is missing
@Test57
Scenario:Validate admin able to update class missing staff id
Given Admin is in  Edit class detail popup window
When Admin enters data missing value in staff id and clicks save button (Batch ID , No of Classes, Class Date )
Then staff id is missing
@Test58
Scenario:Validate  admin able to update class passing past date 
Given Admin is in  Edit class detail popup window
When Admin enters passed date in the class date field and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then class cannot be updated for the passed date and through error message.
@Test59
Scenario:Validate cancel button function in Edit class details popup window
Given Admin is in  Edit class detail popup window
When Admin clicks Cancel button without entering values in the fields
Then Admin should land on Manage Class page
@Test60
Scenario:Validate cancel button function in Edit class details popup window with values in field
Given Admin is in  Edit class detail popup window
When Admin clicks Cancel button entering values in the fields
Then Admin should land on Manage Class Page and validate particular class details are not changed  in the data table