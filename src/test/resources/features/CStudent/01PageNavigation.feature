Feature: Navigation Validation from student page to other Pages


Scenario: Program link on navigation bar
Given Admin is on student details page
When Admin clicks on "program" link on student page
Then Admin is redirected to Program page

Scenario: Batch link on navigation bar
Given Admin is on student details page
When Admin clicks on "Batch" link on student page
Then Admin is redirected to Batch page

Scenario: Class link on navigation bar
Given Admin is on student details page
When Admin clicks on "Class" link on student page
Then Admin is redirected to Class page


Scenario: User link on navigation bar
Given Admin is on student details page
When Admin clicks on "User" link on student page
Then Admin is redirected to User page


Scenario: Assignment link on navigation bar
Given Admin is on student details page
When Admin clicks on "Assignment" link on student page
Then Admin is redirected to Assignment page


Scenario: Attendance link on navigation bar
Given Admin is on student details page
When Admin clicks on "Attendance" link on student page
Then Admin is redirected to Attendance page


Scenario: Logout link on navigation bar
Given Admin is on student details page
When Admin clicks on "Logout" link on student page
Then Admin is redirected to Login page
