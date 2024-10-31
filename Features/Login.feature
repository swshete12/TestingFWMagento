Feature: Test Magento Login Suite

Background:
    Given User Launch Chrome browser

#Positive Scenario : For  login
Scenario: Successful Login with Valid User Name and Password
    When User opens URL "https://magento.softwaretestingboard.com/customer/account/login"
    And User enters Email as "swapnill_shete@yahoo.co.in" and Password as "Admin@#$123"
    And Click on Login
    Then Landing Login content Should be "Welcome"
    When User click on Log Out link
    And close


#Negative Scenario : For login
Scenario: Login with invalid Credentials
    When User opens URL "https://magento.softwaretestingboard.com/customer/account/login"
    And User enters Email as "swapnill_shete@yahoo.co.in" and Password as "Admin@123"
    And Click on Login
    Then Landing Page Should be on same page with alert message "The account sign-in was incorrect"
    And close


#Negative Scenario : For login with Empty User Name and Password