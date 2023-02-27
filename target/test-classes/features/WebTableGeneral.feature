
Feature: Some of the general functionality verification

  Background:
    Given user is on the Web Table login page

  Scenario: Dropdown options verification
    When user is already logged in to the Web Table app
    And user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |


  Scenario: Checkbox options verification
    When user is already logged in to the Web Table app
    And  user is on the Order page
    Then  user sees Visa radio buttons enabled for
    Then  user sees Mastercard radio buttons enabled for
    Then  user sees American Express radio buttons enabled for

  Scenario: Order placement scenario
    When user is already logged in to the Web Table app
    And  user is on the Order page
    And user enters Quantity "2"
    Then user clicks calculate btn
    And user enters Customer name "Jane Doe"
    And user enters Street "7th Street"
    And user enters City "New York"
    And user enters State "New York"
    And user enters Zip "9999"
    And user select payment option "American Express"
    And user enters Card No "2123456456789785"
    And user enters Expire date "12/25"
    And user clicks to “Process Order”
   Then user should see "Jane Doe"  in the first row of the table on View all orders page

  @wip_task
  Scenario Outline: Order placement scenario
    When user is already logged in to the Web Table app
    And  user is on the Order page
    And user enters Quantity "<quantity>"
    Then user clicks calculate btn
    And user enters Customer name "<customerName>"
    And user enters Street "<street>"
    And user enters City "<city>"
    And user enters State "<state>"
    And user enters Zip "<zip>"
    And user select payment option "<paymentType>"
    And user enters Card No "<cardNo>"
    And user enters Expire date "<cardExp>"
    And user clicks to “Process Order”
    Then user should see "<expectedName>"  in the first row of the table on View all orders page

  Examples:
    |quantity|customerName|street|city|state|zip|paymentType|cardNo|cardExp|expectedName|
    |3|John Doe|7th st|NY|NY|9999|American Express|7418529639638521|12/25|John Doe|
    |4|Hannan Orhan|8th st|Canada|BC|7777|Visa|7418529639638521|12/26|Hannan Orhan|
    |10|Bilal Orhan|8th st|Seattle|WD|7777|Visa|7418529639638521|12/25|Bilal Orhan|
    |2|Belkis Orhan|8th st|Elazig|TR|7777|Visa|7418529639638521|12/26|Belkis Orhan|

      #Scenario: Checkbox options verification
   # When user is already logged in to the Web Table app
    #And  user is on the Order page
    #Then Then user sees below radio buttons enabled for
     # | Visa             |
      #| Mastercard       |
      #| American Express |

