Feature: Landing Page
  #succeess
  Scenario: I want to open website cartenz group
    Given I open browser
    Then  I open website cartenz group

  #succeess
  Scenario: I want play video profile company
    Given I open browser
    And I open website cartenz group
    When I click button play
    Then Video profile company playing

  #succeess
  Scenario: I want to know about company
    Given I open browser
    And I open website cartenz group
    When I click "ABOUT" on navbar
    Then Information about the company appears

  #succeess
  Scenario: I want to know news company
    Given I open browser
    And I open website cartenz group
    And I click "NEWS" on navbar
    And News about the company appears
    When I click news detail
    Then The news detail open

  #succeess
  Scenario: I want to know value company
    Given I open browser
    And I open website cartenz group
    When I scroll into value section
    Then Information Value the company appears

  #succeess
  Scenario: I want to know company leader
    Given I open browser
    And I open website cartenz group
    When I scroll into ourleader section
    Then Information about leader of the company appears

  #succeess
  Scenario: I want to know company technology
    Given I open browser
    And I open website cartenz group
    And I click "OUR COMPANIES" on navbar
    When I click learn more about cartenz technology
    Then I was directed to the website cartenz.co.id

  #succeess
  Scenario: I want to know company integrity
    Given I open browser
    And I open website cartenz group
    When I click "OUR PEOPLE" on navbar
    Then Information people about the company appears

  #succeess
  Scenario: I want to know information career
    Given I open browser
    And I open website cartenz group
    And I click "CAREER" on navbar
    When Carrer about the company appears
    Then I choose an available role

  #succeess
  Scenario: I want to see the office location from google maps
    Given I open browser
    And I open website cartenz group
    And I scroll into footer section
    And I copy company address
    And I open google maps
    When I paste company addres
    Then Company appears on google maps

  #succeess
  Scenario: I want to see the company linkedin
    Given I open browser
    And I open website cartenz group
    And I scroll into footer section
    When I click icon linkedin
    Then I was directed to the linkedin cartenz.co.id

