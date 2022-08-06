Feature: demo karate test script
  Background:
    * url 'http://localhost:8080'

  Scenario: 該当データあり
    Given path '/selectUser'
    And param userId = '0001'
    And header Accept = 'application/json'
    When method get
    Then status 200
    And match response.userId == '0001'
    And match response.password == 'passw0rd'
    And match response.userName == 'demoUser01'
    And match response.birthday == '1991-09-06'
    And match response.age == 30
    And match response.gender == 1
    And match response.departmentId == 1
    And match response.role == 'ROLE_ADMIN'
    And match response.department.departmentId == 1
    And match response.department.departmentName == 'System management department'

  Scenario: 該当データなし
    Given path '/selectUser'
    And param userId = ''
    And header Accept = 'application/json'
    When method get
    Then status 200
    And match response == ''