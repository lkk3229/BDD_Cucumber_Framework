Feature: Login

  Scenario: Successful login with Valid Credentials
    Given User launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

  Scenario Outline: login Data Driven
  	Given User launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser
    
    Examples:
    		| email | password |
    		| admin@yourstore.com | admin |
    		| admin1@yourstore.com | admin123 |