Feature: As a user i want to add a book easily so that the reference is saved

Scenario: user can add a new book reference
    Given add new is selected
    When correct title "Testikirja" and author "Tero Testi" and publisher "Wsoy" and year "2017" are added
    Then form is submitted and list of references is displayed
