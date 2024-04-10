Feature: Student Page verification
Background:
Given Admin is on dashboard page after Login
When Admin clicks "Student" on the navigation bar

Scenario: Validate the title of the page 


Then Admin should see the Student details Page Title


Scenario: Validate response time from dashboard page to student page

Then Maximum navigation time in milliseconds, defaults to 30 seconds


Scenario: Validate the broken link

Then HTTP response >= 400. Then the link is broken


Scenario: Verify LMS title 

Then HTTP response >= 400. Then the link is broken


Scenario: Verify the alignment of the Student detail title


Then Student Detail title should be in centre of the page


Scenario: Validate drop down is present in the page down

Then 2 dropdowns should be present in the page


Scenario: Validate search bar in select batch id drop down


Then Admin should see search box inside batch id drop down

 
Scenario: Validate text spelling student name

Then Admin should see correct spelling select student name


Scenario: Validate text spelling select batch id

Then Admin should see correct spelling select batch id text


Scenario: Validate only numbers inside select batch id


Then Admin should see only numbers inside batch id drop down


Scenario: Validate gray color in student name drop down


Then Admin should see select student name in gray color


Scenario: Validate gray color in student name drop down

Then Admin should see select batch ID in gray color


Scenario: Validate first drop down label is select student name

Then Admin should see select student name in first


Scenario: Validate second drop down label is select batch id

Then Admin should see select batch id in second


Scenario: Validate scroll down inside student name dropdown

Then Admin should able to scroll down to select the name


Scenario: Validate scroll down inside batch id dropdown

Then Admin should able to scroll down to select the batch id


Scenario: Validate select student name is fading
GivenAdmin is on student details page

Then Admin should not see select "student" name text

 
Scenario: Validate select batch id is fading

Then Admin should not see select "batch" id text 


Scenario: Validate select student name using search box

Then Admin should see student name start with x is listed below


Scenario: Validate select batch id using search box


Then Admin should see batch id start with x is listed below


Scenario: Validate selecting only student name will not display any details
Given Admin is on student details page	
When Admin select student name from the drop down

Then Student details shouldn't be displayed


Scenario: Validate selecting only batch id will not display any details
Given Admin is on student details page
When Admin selects only batch id from the drop down
Then Student details shouldn't be displayed


Scenario: Validate selecting student name and batch id
Given Admin is on student details page
When Admin selects student name and batch id from drop down


Then Particular student informations "studentname","batchid","studentnameview" should be display