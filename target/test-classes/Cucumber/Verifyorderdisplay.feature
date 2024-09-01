
@tag
Feature: Verifying the Order
  I want to use this template for my feature file 
  
  Background: 
  Given I landed on E-commerce page

  @Orderdisplay
  Scenario: positive test of order display 
  Given I logged in with username<name> and password<pass> 
  When I go to orders page 
  Then check whether the particular product <product> is in orders page 
  
  
   Examples: 
      | name                     | pass           | product  |
      | srinivas.51423@gmail.com | Srinivasrahul5$| ADIDAS ORIGINAL |
     
  


