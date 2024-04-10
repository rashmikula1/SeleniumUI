@tag2
Feature: Class detail Popup window verification

Background:Admin is on Manage Class Page
Given Admin navigate to the Manage class Page
When Admin click +Add New Class button
@Test21
Scenario:Verify class details popup window
Then Admin should see a popup  with  heading "class details"
@Test22
Scenario:Verify input fields in class details popup window
Then Admin should see input fields Text (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)
@Test23
Scenario:Verify text box present in class details popup window
Then Multiple textbox should be  present in Class details popup window
@Test24
Scenario:Verify drop down in Batch Id  in class details popup window
Then Admin should see  dropdown option for Batch ID
@Test25
Scenario:Verify drop down in Staff Id  in class details popup window
Then Admin should see  dropdown option for Staff Id
@Test26
Scenario:Verify calendar icon in class date  in class details popup window
Then Admin should see  calendar icon for class date
@Test27
Scenario:Verify save button is present
Then Admin should see  save button in the class detail popup window
@Test28
Scenario:Verify cancel button is present
Then Admin should see  cancel button in the class detail popup window
@Test29
Scenario:Verify close button in class details popup window
Then Admin should see  close button on the class details popup window