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

# 2938, 1179, 562, 1633, 2961, 891, 2941, 2963
# Example xpath = catnav-primary-link-2938-link
#"Clothing & Accessories", "Jewelry", "Craft Supplies & Tools", "Weddings", "Entertainment", "Home & Living", "Kids & Baby", "Vintage"

@tag
Feature: Verify link titles from "https://www.etsy.com"
  Verify the link titles in a specific URL

  @tag1
  Scenario Outline: Open the browser
    Given The browser is invoked and url is loaded
    When I get actual linktitle from <tagid>
    Then Verify <expected_link> equals actual link

    Examples: 
      | tagid | expected_link          |
      |  2938 | Clothing & Accessories |
      |  1179 | Jewelry                |
      |   562 | Craft Supplies & Tools |
      |  1633 | Weddings               |
      |  2961 | Entertainment          |
      |   891 | Home & Living          |
      |  2941 | Kids & Baby            |
      |  2963 | Vintage                |
