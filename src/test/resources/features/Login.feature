Feature: User Login
  Scenario: Successful login
    Given the user is on the login page
    When they enter valid username
    And they enter valid password
    And they click on the Login Button
    Then they should be redirected to the dashboard

    #this is the feature file this defines the feature you want to test.
    # here we are testing Login