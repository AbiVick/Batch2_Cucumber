Feature: Login functionality


@ibm_sanity
Scenario: login with valid user details

Given User launch chrome browser
When user open app URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "admin@yourstore.com" and password as "admin"
And click on Login
Then page title should be "Dashboard / nopCommerce administration"
When user click on Logout link
Then page title should be "Your store. Login"
And close browser


@ibm_regression
Scenario Outline: login with multiple user details 

Given User launch chrome browser
When user open app URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "<email>" and password as "<pass>"
And click on Login
Then page title should be "Dashboard / nopCommerce administration"
When user click on Logout link
Then page title should be "Your store. Login"
And close browser


Examples:	
   				|     email               										| 		pass 											|
   				|		admin@yourstore.com												|			admin											|
   				|		admin123@yourstore.com										|			admin123									|