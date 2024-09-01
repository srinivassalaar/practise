
@tag
Feature: Error validatiion
  I want to use this template for my feature file
   Background: 
  Given I landed on E-commerce page

 @tag1
  Scenario Outline: negative test of error validation
    
    When I logged in with username<name> and password<pass> 
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                     | pass           |
      | srinivas.51423@gmail.com | Srinivrahul5$  |
 
 @tag2
 Scenario Outline: negative test of product error validation
   
    When I logged in with username<name> and password<pass> 
    And Going to products page and cart page for the req pro <product>
    Then verify the rquired product is in cart page or not <product>

    Examples: 
      | name                     | pass           | product    |
      | srinivas.51423@gmail.com | Srinivasrahul5$  |ADIDAS ORIGINAL|