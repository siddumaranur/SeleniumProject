Feature: Application Login

Scenario: Login with Valid Credentials
Given Open any Browser
And Navigate Login Page
When use enter username as "siddumaranur371@gmail.com" and Password as "Siddu999"
And user click on Login Button
Then Verify user is able to successfully Login
