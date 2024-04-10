Feature: ResetPassword page validation
  
  Rule: Verifying ResetPassword page

  Background: Logged on the LMS portal as Admin
    Given Admin is in login page
    When Admin clicks reset password link and landed on reset password page

  #1
  Scenario: Verify  text in the page
    Then Admin should see correct spellings in all reset password fields

  #2
  Scenario: Verify submit button is present
    Then Admin should see "submit"  button in reset password page

  #3
  Scenario: Verify the alignment of the  submit button
    Then Admin should see submit button in center of the reset password page

  #4
  Scenario: Verify text box is present is the page
    Then Admin should see two text box in reset password page

  #5
  Scenario: Verify first label text
    Then Admin should see "Type in new password" in the first label text

  #6
  Scenario: Verify second label text
    Then Admin should see "Retype password" in the second label text

  #7
  Scenario: verify text box is in disabled
    Then Admin should see text box in disabled state in reset password page

  #8
  Scenario: verify text box is in enabled in new password field
    And Admin clicks on type in new password field
    Then Admin should see text box is enabled state

  #9
  Scenario: verify text box is in enabled in retype password field
    And Admin clicks on retype password field
    Then Admin should see text box is enabled state

  #10
  Scenario Outline: Validate reset password with valid details
    And Admin enters same password from "<SheetName>" and <RowNumber> in both field
    And click submit button
    Then Admin should recieve : "Your password has been reset". Please click here to login

    Examples: 
      | SheetName      | RowNumber |
      | Reset_Password |         0 |

  #11
  Scenario Outline: Validate reset password with invalid details
    And Admin enters  invalid password from "<SheetName>" and <RowNumber> in both field
    Then Admin clicks submit button	Error message will be "Please try again"

    Examples: 
      | SheetName      | RowNumber |
      | Reset_Password |         1 |

  #12
  Scenario Outline: Validate reset password with empty details
    And Admin doesnot enter  any passwords from "<SheetName>" and <RowNumber>
    Then Admin clicks submit button	Error message will be "Please try again"

    Examples: 
      | SheetName      | RowNumber |
      | Reset_Password |         2 |

  #13
  Scenario Outline: Validate reset password mismatch values
    And Admin enters  mismatch values from "<SheetName>" and <RowNumber>
     Then Admin clicks submit button	Error message will be "Please try again"

    Examples: 
      | SheetName      | RowNumber |
      | Reset_Password |         3 |
