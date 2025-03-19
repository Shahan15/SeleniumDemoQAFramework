Feature: User Login
  Scenario: Successful login
    Given the user is on the login page
    When they enter valid credentials
    Then they should be redirected to the dashboard

    #this is the feature file this defines the feature you want to test.
    # here we are testing Login