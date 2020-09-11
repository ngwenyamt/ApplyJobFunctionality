Feature: Apply Job Online Functionality

  Scenario Outline: Apply Job Online Functionality test
    Given user navigate to the current job openings
    Then user select the first available job hyperlink
    And user click on Apply Online button
    And user input a first "<name>"
    And user input "<email>" address
    And user input phone number
    And user input "<message>"
    And user click on Send Application


    Examples:

    |name|email|message|
    |Tebogo|automationAssessment@iLABQuality.com|I here by apply for the Automation Test Engineer Position at ILAB Quality.Hope to hear soon from your positive response.|



