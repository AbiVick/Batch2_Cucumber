Feature: Customers 


Background:
    Given User launch chrome browser
    When user open app URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can view Dashboad 
    When User click on customers Menu 
    And click on customers Menu Item 



@sanity
Scenario: Add new Customer 

    And click on Add new button 
    Then User can view Add new customer page 
    When User enter customer info 
    And click on Save button 
    Then User can view confirmation message "The new customer has been added successfully." 
    And close browser



@regression
Scenario: Search Customer by EMailID 
    
    And Enter customer EMail
    When Click on search button
    Then User should found Email in the Search table
    And close browser 
    
@smoke
Scenario: Search Customer by Name
    
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser