@Search @smoke @noBefore
Feature: Baidu Search
  Open Baidu page and Click Search Button

  @BaiduSearch
  Scenario: Baidu Search With Selenium
    Given Go to baidu home
    When I find baidu logo
    And Type the search text "selenium"
    And Click the submit
    Then Wait the query result