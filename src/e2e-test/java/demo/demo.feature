Feature: demo karate test script
  Background:
    * url 'http://localhost:8080'

  Scenario: get userInfo by id
    Given path '/demo'
    And param userId = '0001'
    And header Accept = 'application/json'
    When method get
    Then status 200
    And match response.userId == '0001'
    And match response.userName == 'demoUser01'
    And match response.age == 30

  Scenario: get userInfo by id
    Given path '/demo'
    And param userId = ''
    And header Accept = 'application/json'
    When method get
    Then status 200
    And match response == ''