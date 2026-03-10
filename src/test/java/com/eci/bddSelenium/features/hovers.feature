Feature: Hover functionality

  Scenario: Hover over first user and display profile
    Given I am on the hovers page
    When I hover over the first user
    Then the username "name: user1" should be visible