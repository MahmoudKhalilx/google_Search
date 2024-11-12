# Selenium Java Automation: Google Search Results Validation

## Project Overview
This project automates a sequence of steps on Google Search using Selenium and Java with TestNG. The test script simulates entering a search query, navigating between search results pages, verifying the number of search results, and checking consistency across pages.

## Test Case Details
The automated test script performs the following sequence of steps:

1. **Navigate to Google Search Page**
   - URL: `https://www.google.com/`

2. **Enter Search Query**
   - The search term is dynamically fetched from a JSON file.

3. **Navigate to the Next Search Results Page**
   - Click on the "Next" button to go to subsequent search results pages.

4. **Get and Verify Number of Results**
   - Extract the number of results on page 2 and page 3.
   - Verify that the number of results remains consistent between these pages.

5. **Verify Current Page**
   - Assert that the user is on the correct search results page based on the URL parameters.

## Running the Tests
To execute the tests:
- Execute the test class directly from your IDE or use the Maven command:
  ```sh
  mvn clean test
  ```

- To generate an Allure report:
  ```sh
  allure serve target/allure-results
  ```

## Dependencies
- **Selenium WebDriver**: Automates web browser interaction.
- **TestNG**: Framework for running test cases and assertions.
- **Maven Surefire Plugin**: Used to execute TestNG tests via Maven.


