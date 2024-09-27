# Appium Automation Framework

Welcome to the **Appium Automation Framework**! This project is designed to help QA engineers automate mobile application testing using Appium, TestNG, and Maven. It offers a scalable and reusable structure, making mobile test automation more efficient and maintainable.

## Table of Contents

- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Running Tests](#running-tests)
- [Folder Structure](#folder-structure)
- [Contributing](#contributing)
- [Support](#support)

---

## Project Overview

This project is an automation framework designed for testing mobile applications using the Appium tool. It supports native Android testing and can easily be extended for iOS. Test cases are written in Java, with TestNG as the test runner and Maven for build management. The project uses the Page Object Model (POM) design pattern to organize locators and actions, making it maintainable and reusable.

### Features:

- **Page Object Model (POM)** for better maintainability.
- Supports **multiple environments** through Maven profiles.
- **Dynamic waits** for better test reliability.
- Detailed **Extent Reports** for test results.
- Integration with **CI/CD pipelines**.
- **Cross-platform support** (easily adaptable to iOS).

---

## Technology Stack

- **Appium** (v9.3.0): Automating mobile apps.
- **TestNG** (v7.10.2): Test framework.
- **Maven**: Build management.
- **Extent Reports** (v5.1.2): For enhanced reporting.
- **Java** (v11): Programming language.

---

## Prerequisites

Ensure that the following dependencies are installed:

1. **Java 11** or later
2. **Maven** (latest version recommended)
3. **Node.js** (to install Appium server)
4. **Android SDK** and **Emulator** (for Android testing)
5. **Appium Desktop** (or Appium CLI)

### To verify if Java and Maven are installed:

```bash
java -version
mvn -version
```

## Project Setup

Clone the Repository:

- `git clone https://github.com/dnzioka/mobile_automation.git`
- `cd mobile_automation`

Install dependencies:

`mvn clean install`

Configure your environment:

1. Set the Android SDK path in your environment variables.
2. Configure your emulator or real device for testing.

Set up Appium:

1. Start the Appium server using the desktop app or CLI.
   - - `appium`

## Running Tests

You can run the tests using Maven profiles to execute specific test suites:

- Run the default test suite:
  `mvn clean test`
- Run a specific test profile (e.g., accounts):
  `mvn clean test -P accounts`

## Generate reports after the test run:

Reports are automatically generated and can be found in the `/Reports folder`.

## Folder Structure

Here is a quick look at the folder structure:

```
  ├── Reports/ # Test reports generated after execution
  ├── resources/ # Resources like test data and APK files
  │ ├── apk/ # APK files for Android testing
  ├── src/
  │ ├── main/ # Core Java files, Page Object classes
  │ ├── test/ # Test classes and suites
  │ └── TestNGSuites/ # Test suite XML files
  │ └── accounts.xml
  ├── .gitignore # Files to ignore in Git
  ├── pom.xml # Maven build configuration
  └── README.md # Project documentation
```

## Contributing

1. Fork the repository.
2. Create a new branch:
   `git checkout -b feature-branch`
3. Commit your changes:
   `git commit -m "Add feature XYZ"`
4. Push to the branch:
   `git push origin feature-branch`
5. Create a Pull Request.

## Support

For any queries or help, feel free to reach out by opening an issue on GitHub.

```
|  |  |
|------------------|------------------------------|
| 🏷️ **Title**      | QA Engineer                  |
| 📛 **Name**       | Dominic Malile               |
| 📱 **Phone**      | +254710961016                |
```

| 🔗 **LinkedIn** | [Connect with me on LinkedIn](https://www.linkedin.com/in/dominicmalile/) |

| LinkedIn Profile | [Connect with me on LinkedIn](https://www.linkedin.com/in/dominicmalile/) |

Happy Testing!
