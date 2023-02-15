# CV Automation Demo

UI Automation Framework

Video demo: https://youtu.be/YlPbaxIHOYg


# Purpose

This is an automation testing environment built using Maven, Java, Cucumber and Selenium. \
The example test case scenario created here has the objective not to test an app, but to demonstrate the author's knowledge of automation by filling up information on an online CV Template. \
It's final purpose is to be sent to recruiters, as an attachment to my personal CV.


# Minimum requirements

- Windows OS
- JDK8
- IDE that supports Cucumber
- Mozilla Firefox


# Environment Installation

1. Install JDK8 and set a Windows environment variable as JAVA_HOME pointing at the jdk install dir.
2. Edit "Path" environment variable by adding %JAVA_HOME%/bin.
3. Open your IDE and install the corresponding "Cucumber for Java" plugin.


# Running the automation

1. Open/Import the proyect into your IDE.
2. Allow Maven some time to download all required libraries.
3. Run TestRunner.java located in /src/test/java/runner/


# Considerations

The environment is not fully built and not meant for real testing; Some key features and components are missing for such a task. \
Further functionality for different OS and Browser support might be added to the proyect in the future. \
This work is the result of several hours of practice and learning how to code from various sources. \
Some instability is to be expected, as the proyect has only been tested on my personal computer and still needs finer adjustments. \
At the first run, some exception might occur that fails the test. Simply re-run the test and it should work.
