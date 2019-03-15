Feature: Make an Appointment
  This feature is checking whether user can make an appointment properly without issues

  Scenario: User make an appointment
    When I should see application loaded properly
    When I click on Make Appointment button
    Then I should navigate to the login page
    And I should see login page loaded properly
    When I entered my username and password
    | username | password |
    | John Doe | ThisIsNotAPassword |
    Then I should navigated to the make appointment page
    And I should see make appointment page loaded properly