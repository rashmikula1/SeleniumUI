Feature: Log in page

  Background: Logged on the LMS portal as Admin
    Given Admin is in login page

  #1
  Scenario: Verify the header of the login page
    When Admin clicks Login button
    Then Admin should see "Please login to LMS application" in the header

  #2
  Scenario: Verify the text spelling in login page
    When Admin clicks Login button
    Then Admin should see correct spellings in all fields of login page

  #3
  Scenario: Verify text field is present
    When Admin user clicks login button
    Then Admin should see two text field

  #4
  Scenario: Verify text on the first text field
    
    Then Admin should see "user" in the first text field

  #5
  Scenario: Verify asterik next to user text
    When Admin clicks Login button
    Then Admin should see "*" symbol next to user text

  #6
  Scenario: Verify text on the second text field
    When Admin clicks Login button
    Then Admin should see "password" in the second text field

  #7
  Scenario: Verify asterik next to password text
    When Admin clicks Login button
    Then Admin should see "*" symbol next to password text

  #8
  Scenario: Verify the alignment input field for the login
    When Admin clicks Login button
    Then Admin should see input field on the centre of the page

  #9
  Scenario: verify Login is present
    When Admin clicks Login button
    Then Admin should see login button

  #10
  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the page

  #11
  Scenario: Verify forgot username or password link
    Then Admin should see forgot username or password link

  #12
  Scenario: Verify for the Reset password link
    Then Admin should see reset password link

  #13
  Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color

  #14
  Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color

  #15
  Scenario Outline: Validate login with valid credentials
    When Admin enter valid username "<SheetName>" and  valid password <RowNumber>
    And Admin clicks Login button
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         0 |

  #16
  Scenario Outline: verify login button action through keyboard
    When Admin enter valid username "<SheetName>" and  valid password <RowNumber>
    And clicks login button through keyboard
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         0 |

  #17
  Scenario Outline: verify login button action through mouse
    When Admin enter valid username "<SheetName>" and  valid password <RowNumber>
    And user clicks login button through mouse
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         0 |

  #18
  Scenario Outline: Validate login with invalid credentials
    When Admin enter invalid username "<SheetName>" and  invalid password <RowNumber>
    And Admin clicks Login button
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         1 |

  #19 Negative Scenario
  Scenario Outline: Validate login with blank username credentials
    When Admin enter blank username "<SheetName>" and  valid password <RowNumber>
    And Admin clicks Login button
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         2 |

  #20
  Scenario Outline: Validate login with blank password credentials
    When Admin enter valid username "<SheetName>" and  blank password <RowNumber>
    And Admin clicks Login button
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         3 |

  #21
  Scenario Outline: Validate login with valid username invalid password
    When Admin enter valid username "<SheetName>" and  invalid password <RowNumber>
    And Admin clicks Login button
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         4 |

  #22
  Scenario Outline: Validate login with invalid username valid password
    When Admin enter invalid username "<SheetName>" and  valid password <RowNumber>
    And Admin clicks Login button
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         5 |

  #23
  Scenario Outline: validate login with empty values in both field
    When Admin clicks login button with blank username "<SheetName>" and  blank password <RowNumber>
    Then Error message please check username or password

    Examples: 
      | SheetName  | RowNumber |
      | Login_Page |         6 |
