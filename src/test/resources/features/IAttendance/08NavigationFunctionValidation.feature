Feature: Navigation function validation from manage attendance page to other pages  

Background: Admin is manage class page after logged in
Given Admin is in manage attendance page

Scenario: Verify admin is able to navigate from manage attendance to student page
When Admin clicks "Student" button in the navigation bar in attendance
Then Admin should able to land on student page from attendance

Scenario: Verify admin is able to navigate from manage attendance to program page
When Admin clicks "Program" button in the navigation bar in attendance
Then Admin should able to land on program page from attendance

Scenario: Verify admin is able to navigate from manage attendance to batch page
When Admin clicks "Batch" button in the navigation bar in attendance
Then Admin should able to land on batch page from attendance

Scenario: Verify admin is able to navigate from manage attendance to user page
When Admin clicks "User" button in the navigation bar in attendance
Then Admin should able to land on user page from attendance

Scenario: Verify admin is able to navigate from manage attendance to assignment page
When Admin clicks "Assignment" button in the navigation bar in attendance
Then Admin should able to land on Assignment page from attendance

Scenario: Verify admin is able to navigate from manage attendance to attendance page
When Admin clicks "Class" button in the navigation bar in attendance
Then Admin should able to land on class page from attendance

Scenario: Verify adminshould able to do logout function from manage attendance
When Admin clicks "Logout" button in the navigation bar in attendance
Then Admin should able to land on login page from attendance







