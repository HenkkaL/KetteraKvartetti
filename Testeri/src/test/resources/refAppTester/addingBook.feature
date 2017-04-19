Feature: As a user i want to add a book easily so that the reference is saved

Scenario: user can add a new book reference with minimum metadata
    Given add new "book" is selected
    When correct referencId "testi" is given
    And correct author "Tero Test" is given
    And correct title "Testikirja" is given
    And correct year "1234" is given
    And correct publisher "Pub" is given
    And form is submitted
    Then page has content "Listataan kaikki viitteet"

Scenario: user can add a new book reference with maximum metadata
    Given add new "book" is selected     
    When correct referencId "testi" is given
    And correct author "Tero Test" is given
    And correct title "Testikirja" is given
    And correct year "1234" is given    
    And correct month "02" is given
    And correct publisher "Pub" is given
    And correct edition "1. edition" is given
    And correct volume "1" is given
    And correct series "series name" is given
    And correct address "Testaddress 2" is given
    And correct note "notes" is given
    And correct pages start "12" and end "123" are given
    And form is submitted
    Then page has content "Listataan kaikki viitteet"

Scenario: user fails to give book referenceId 
#    Given add new "book" is selected
#    When correct title "Testikirja" is given
#    And correct author "Tero Test" is given
#    And correct year "1234" is given
#    And correct publisher "Pub" is given
#    And form is submitted
#    Then field "referenceId" is needed
    

#Scenario: user fails to give book title
#    Given add new "book" is selected
#    When correct referencId "testi" is given
#    And correct author "Tero Test" is given
#    And correct year "1234" is given
#    And correct publisher "Pub" is given
#    And form is submitted
#    Then page has content "Lisää uusi viite"

#Scenario: user fails to give book author
#    Given add new "book" is selected
#    When correct referencId "testi" is given
#    And correct title "Testikirja" is given
#    And correct year "1234" is given
#    And correct publisher "Pub" is given
#    And form is submitted
#    Then page has content "Lisää uusi viite"

#Scenario: user fails to give book year
#    Given add new "book" is selected
#    When correct referencId "testi" is given
#    And correct title "Testikirja" is given
#    And correct author "Tero Test" is given
#    And correct publisher "Pub" is given
#    And form is submitted
#    Then page has content "Lisää uusi viite"


#Scenario: user fails to give book bublisher
#    Given add new "book" is selected
#    When correct referencId "testi" is given
#    And correct title "Testikirja" is given
#    And correct author "Tero Test" is given
#    And correct year "1234" is given
#    And form is submitted
#    Then page has content "Lisää uusi viite"