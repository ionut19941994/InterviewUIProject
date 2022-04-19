Feature: Actions on a RestAPI endpoints

  Scenario: Successfully retrieves all employees and counts the number of employees with age number higher than 30
    Given the user makes GET request to /employees endpoint
    When user will get a 200 response
    Then The response should contain the valid data
