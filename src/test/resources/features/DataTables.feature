Feature: Cucumber data tables implementation practices


  Scenario: List of fruits ans vegetables
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |

#create new scenario where we list the type of pets we love
  #print out all the strings in the list

  Scenario: List of pets
    Then user should see below pet list
      | dog       |
      | cat       |
      | dolphin   |
      | bird      |
      | hamster   |
      | hedgehog  |
      | chameleon |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane         |
      | surname | Doe          |
      | age     | 29           |
      | state   | CA           |
      | address | somewhere    |
      | zipcode | 123456       |
      | phone   | 111-111-1111 |

  @dataTable
  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January |
      | February |
      | March |
      | April |
      | May |
      | June |
      | July |
      | August |
      | September |
      | October |
      | November |
      | December |