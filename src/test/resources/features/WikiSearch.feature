Feature: Wiki search features

  Background:
    Given User is on Wikipedia home page


  Scenario: Wikipedia Search Functionality Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  @WPS
  Scenario Outline: Wikipedia Search Functionality with scenario outline
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedImgHeader>" is in the image header

    @ceos
    Examples: search values we are going to be using in this scenario outline
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImgHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs        |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer    | Rosalind Brewer   |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai      | Sundar Pichai     |

    Examples:

      | searchValue     | expectedTitle   | expectedMainHeader | expectedImgHeader |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Curie       |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein   |