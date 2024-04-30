# Software dependencies
- Java
- Selenium
- POM
- TestNG
- Cucumber
- Allure

# Run test cases
mvn clean test -Dcucumber.filter.tags="@PAA006-01"

# Open allure execution report
allure serve target\allure-results

![image](https://github.com/daniellhoyos/SeleniumPOMCucumber/assets/68720765/8af59f3c-31d0-4ebd-8fc4-973a9717e9ec)
