Feature: Actions on a RestAPI endpoints from ApiTests

  Scenario: User verifies the read EP returns results
    Given the user sends the GET request to 'read' EP
    When the user receives a 200 status
    Then the user is able to see results

  Scenario: User sends a request to the EP
    Given the user sends the GET request to the EP
    When the user receives 200 status code
    Then the user is able to see results