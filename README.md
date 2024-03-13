 Flipkart Website Automation
**Overview**
This project demonstrates automated testing of the Flipkart website using Selenium WebDriver with Java. It includes test scripts to automate various scenarios such as searching for products, adding items to the cart, and performing checkout.

**Setup**
To run the automated tests, you need to have the following software installed:
- Java Development Kit (JDK)
- Selenium WebDriver
- WebDriver-compatible browser drivers (e.g., ChromeDriver for Google Chrome)
  
**Dependencies**
- Java 8 or higher
- Selenium WebDriver
- Cucumber-Java
- Cumcumber Junit
- Junit
- assetj-core
  
**Installation**
1. Install Java Development Kit (JDK) if you haven't already.
2. Download Selenium WebDriver and WebDriver-compatible browser drivers (e.g., ChromeDriver).
3. Set up your project in an IDE of your choice (e.g., IntelliJ IDEA, Eclipse).
4. Add dependencies to your project's build path or Maven/Gradle configuration.
   
**Usage**
1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Modify the test scripts in the `src/test/java` directory to suit your testing requirements.
4. Run the test scripts using TestNG or your IDE's test runner.
   
**Test Scripts**
The test scripts are organized into different packages based on functionality. Here's a brief overview of each package:
- `com.shopnow.testrunner`: Contains the featurerunner to run the features
- `com.shopnow.pages`: Includes Page Object Model (POM) classes representing different pages of the Flipkart website.
- 'com.shopnow.stepdefs' : Contains glue code for the steps in the feature file

**Configuration**
You can customize browser settings by modifying the configuration parameters in the `src/test/resources/browser.properties` file.

**Contributing**
Contributions to this project are welcome! If you find any bugs, have feature requests, or want to improve the existing test scripts, feel free to open an issue or submit a pull request.
