# Screenploye

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/eed0f78be9d948fab736f4be0aa4a699)](https://app.codacy.com/manual/ZoranZivanovicc/Screenployee?utm_source=github.com&utm_medium=referral&utm_content=ZoranZivanovicc/Screenployee&utm_campaign=Badge_Grade_Dashboard)

This project is created only for testing purpose

# Objective
This is an example of testing framework which should support automation tests for front end testing in java

# Tools/libraries used:
1. Java
2. Selenium Driver
3. WebDriver manager
4. Cucumber
5. Junit
6. Maven

# Setting environment:
1. Need to have installed chrome browser
2. Recommendation is to have intelliJ IDE

# Steps to start:
1. Clone project into your local 
2. Checkout Master or Develope branch
3. Intellij should automaticly use maven to install and download dependency if is not, run maven clean and install

# Execute tests
To run tests there are junit runners, one is to execute all test (TestRunnerRegression) and to select specific test by annotations use TestRunner. Both runners can be found in: src\test\java\runners.
After tests completion you can see report for results: Screenployee\report\index.html
