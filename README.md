# 🧪 SeleniumDemoQAFramework

A scalable and hybrid automation framework built in Java using Selenium WebDriver, TestNG, and Cucumber. It supports both TDD and BDD practices and follows the Page Object Model (POM) design pattern.

This framework is designed for flexibility, maintainability, and real-world use, with modular components for reporting, logging, and data-driven testing.

---

## 🚀 Features

- Selenium WebDriver integration
- BDD with Cucumber & Gherkin syntax
- TDD with TestNG
- Page Object Model (POM)
- ExtentReports for test reporting
- Log4j-based logging
- Utility classes for reusability
- Data-driven testing
- Listener-based failure handling and screenshots

---

## 🛠 Tech Stack

- Java 11+
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- TestNG (TDD)
- Log4j
- ExtentReports

---

## 📁 Project Structure

```text
src/test/java/
├── hooks/               # Cucumber Hooks
├── model/               # Test data models (e.g., Car, Bike)
├── pages/               # Page Object classes
├── runner/              # Cucumber runner class
├── stepdefinitions/     # Step Definitions for BDD
├── scrapers/            # Web scraping logic (e.g., bikes, cars)
├── utils/               # Utilities (Excel, screenshots, waits, logging)
└── org/example/tests/   # TDD-style tests
```
---

## ⚙️ Configuration

Update your test settings in config.properties:

browser=chrome

baseUrl=https://demoqa.com

implicitWait=10

---

## 🧪 Running Tests

TDD Tests (TestNG):

mvn clean test

BDD Tests (Cucumber):

mvn test -Dcucumber.options="src/test/resources/features"

Or use the runner directly if configured with TestNG.

---

## 📊 Reports & Logs

Extent Report: test-output/ExtentReports/ExtentReport.html  
Logs: logs/automation.log  
Screenshots on Failure: screenshots/

---

## 📌 Highlights

- Hybrid approach using both BDD (for behavior clarity) and TDD (for unit-level validation)
- Reusable components like Base.java, TestListener.java, and ExtentReportHelper.java
- Web scrapers for extracting data from UI and validating structure

---

## 📈 To-Do

- [ ] CI Integration (GitHub Actions or Jenkins)
- [ ] Parallel execution using TestNG XML & Cucumber options
- [ ] Refactor scrapers into a service layer
- [ ] Integrate Cucumber HTML Reports

---

## 👤 Author

Shahan  
Quality Engineer | Automation Tester  
https://github.com/Shahan15

---

## 📎 License

This project is licensed for personal and educational use.
