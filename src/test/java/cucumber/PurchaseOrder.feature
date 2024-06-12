

@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of Submitting the order 
    Given Logged in with user name <name> and Passwoerd <password>
    When I add product <productName> to cart And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." meaasge is displayed on confirmationpage

    Examples: 
      | name                  | password | productName    |
      | artesting98@gmail.com | Extra@12 | ADIDAS ORIGINAL|
     