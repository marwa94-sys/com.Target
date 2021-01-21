Feature: User Schould be able to create an account
@smoke
  Scenario Outline: User Should be able to add his Information
    Given user is landed on target front page
    When user clicks on signIn to selects create Account
    When user enter "<Email address>", "<firstname>", "<lastname>", "<phone>" and "<password>"
    Then user can click on create an account button
    Then "<Email address>", "<firstname>", "<lastname>", "<phone>" and "<password>" is added successfully

    Examples: 
      | Email address                 | firstname | lastname | phone      | password        |
      | nouhaila.yaghourtne@gmail.com | Fatima    | redad    | 5713437788 | fatimaRedad30FO |

      

      
      
      
      