Feature: As a user I want to get all references as bibtex file easily

Scenario: user can download all references in bibtex format file
    Given frontpage is selected
    When user selects the download link
    Then bibtex file is downloaded