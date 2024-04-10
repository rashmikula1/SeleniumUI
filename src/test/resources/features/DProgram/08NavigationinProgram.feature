Feature: Navigation Validation from Manage Program to other Pages
Background:
Given Admin is on dashboard page after Login and clicks Program on the navigation bar
#1
Scenario: Student link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on Student link on Manage Program page in program
Then Admin is re-directed to Student page in program
#2
Scenario: Batch link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on Batch link on Manage Program page in program
Then Admin is re-directed to Batch page in program
#3
Scenario: Class link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on class link on Manage Program page in program
Then Admin is re-directed to class page in program
#4
Scenario: User link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on user link on Manage Program page in program
Then Admin is re-directed to user page in program
#5
Scenario: Assignment link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on Assignment link on Manage Program page in program
Then Admin is re-directed to Assignment page in program
#6
Scenario: Attendance link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on Attendance link on Manage Program page in program
Then Admin is re-directed to Attendance page in program
#7
Scenario: Logout link on navigation bar
Given Admin is on Manage Program page in program
When Admin clicks on Logout link on Manage Program page in program
Then Admin is re-directed to Login page in program