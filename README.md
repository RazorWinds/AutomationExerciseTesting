# AutomationExerciseTesting

### Group Members

- Logan Marhsall (Scrum master)
- Owen Graham
- Conner Humphrey
- Kar-Ho Lee

This is a single-sprint group project where we are testing the functionality of [Automation Exercise](https://automationexercise.com/), a website created specifically for practicing automation coding.
To do this we will create a test framework using Selinium for web testing functionality, and Cucumber for making declarative Gherkin-syntax test cases.

## Setup

To run the tests, you will need to download a Chrome driver with a corresponding license. To do this, first update Chrome to the most recent version, and then [download the zip folder relevant for your operating system from here](https://googlechromelabs.github.io/chrome-for-testing/). Extract the files from the folder and make sure that it contains `chromedriver.exe` and `LICENSE.chromedriver`, and move both files into "src/test/resources".

## What was tested?

Tests were written to evaluate the functionality of ten user stories, outlined and agreed upon at the beginning of the project, and suplimented by a timeboxed exploratory testing session. These cover the majority of expectable user journeys on the website. 

## Test Metrics

The definition of done outlines that all user stories should be written with acceptance criteria that cover the majority of use cases, including happy and sad cases, and automated tests should be written for all of these. For any defects found, defect reports must be written with sufficient detail for the defect to be recreated. 

As such, the test metrics we used were:

- number of user stories manually tested
- number of user story tests automated
- number of defects found
- detail of defect reports
- number of tests per user story
