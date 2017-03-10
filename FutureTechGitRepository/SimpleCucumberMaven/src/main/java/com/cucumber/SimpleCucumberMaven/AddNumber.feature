#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Add two number

  Scenario Outline: Add two number
    Given Two integer number "<a>" and "<b>"
    When We perform addition of "<a>" and "<b>"
    Then We should get sum of two number "<Result>"

    Examples: 
      | a   | b   | Result |
      |   2 |   3 |      5 |
      |   2 |   2 |      4 |
      | 100 | 400 |    500 |