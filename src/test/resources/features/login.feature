Feature: Login page

  Scenario: a failed login produces the correct response
    When I attempt to login with invalid credentials
    Then the status code received is 403
