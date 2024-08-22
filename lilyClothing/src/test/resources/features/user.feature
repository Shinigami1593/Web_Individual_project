Feature: User Management

  Scenario: Create a new user
    Given the user name is "JohnDoe"
    And the user password is "password123"
    And the user address is "123 Main St"
    And the user phone is 1234567890
    When the user sends a request to create the user
    Then the user is created successfully

  Scenario: Fetch all users
    When the user sends a request to fetch all users
    Then the list of users is fetched successfully

  Scenario: Fetch user data by ID
    Given the user ID is 1
    When the user sends a request to fetch the user data
    Then the user data is fetched successfully

  Scenario: Update user data
    Given the user ID is 1
    And the new user name is "JaneDoe"
    And the new user password is "newpassword123"
    And the new user address is "456 Main St"
    And the new user phone is 9876543210
    When the user sends a request to update the user data
    Then the user data is updated successfully

  Scenario: Delete user by ID
    Given the user ID is 1
    When the user sends a request to delete the user
    Then the user is deleted successfully
