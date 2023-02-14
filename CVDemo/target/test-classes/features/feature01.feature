Feature: Create a full cv
	As a free, unregistered user, I want to choose a free template and create a full CV.

Scenario: User navigates to template selections.
Given The user is in the main page
When Clics the Free CV Builder button
And Selects a free template
And Chooses a Standard CV skipping the tutorial
And Completes all the data
And Takes a cropped screenshot of the CV
Then Opens the screenshot

