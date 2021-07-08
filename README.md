# Aumni Fund Selenium Tests

## General Info
- Testcases are written to validate UI element interactions on the https://www.aumni.fund
- Page Object model is used to improve test maintenance 
- Log4J is used for logging 
  
## Setting up local Environment
- Chrome Driver
  * Install Chrome-Driver compatible with the Chrome Browser
    * https://chromedriver.chromium.org
  * Make sure ChromeDriver is available on the PATH 
    * e.g. driver location `/usr/local/bin`
- Please install 
  * Java 11
  * Maven 3.x
## How to run
- Command Line
  * on command line navigate to project folder
  * run `mvn test`
- Report generation 
  * `mvn surefire-report:report`
