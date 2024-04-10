Feature: Attendance details popup verification
Background: Admin click +Add New Attendance button after reaching to Manage attendance page
Given Admin is in attendance details popup window

#1
Scenario: Validate all program name is reflecting in the dropdown
When Admin clicks program name dropdown in attendance details popup
Then Program Name in the drop down should match with program name in manage program page table in attendance details popup
#2
Scenario: Validate all class name  is reflecting in the dropdown
When Admin clicks class name dropdown in attendance details popup
Then Class Name in the drop down should match with class name in manage class page table in attendance details popup
#3
Scenario: Validate attendance field dropdown all mandatory keywords
When Admin clicks attendance dropdown in attendance details popup
Then Attendance field should have keywords such as present, absent, late, excused in attendance details popup
#4
Scenario: Verify spellings in the attendance field drop down 
When Admin clicks attendance dropdown in attendance details popup
Then Admin should see correct spellings in dropdown text in attendance details popup
#5
Scenario: Validate date picker
When Admin clicks date from date picker in attendance details popup
Then selected date should be there in attendance date text box in attendance details popup
#6
Scenario: validate date picker should be correct format
When Admin clicks date from date picker in attendance details popup
Then selected date should be in  mm/dd/yyyy format in attendance details popup
#7
Scenario: Validate right arrow in data picker to navigate to next month
When Admin clicks right arrow in the date picker near month in attendance details popup
Then Next month calender should visible in attendance details popup
#8
Scenario: Validate left arrow in data picker to navigate to previous month
When Admin clicks left arrow in the date picker near month in attendance details popup
Then previous month calender should visible in attendance details popup
#9
Scenario: Validate current date is highlighted in the date picker
When Admin clicks date picker button in attendance details popup
Then Admin should see current date is highlighted in the date picker in attendance details popup
#10
Scenario: Validate selected date is highlighted in the date picker 
When Admin clicks date picker button and selects future date in attendance details popup
Then Admin should see selected date is highlighted in the date picker in attendance details popup






































